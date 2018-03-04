package com.heu.poet.tszz.travel;


import com.heu.poet.tszz.customer.Customer;
import com.heu.poet.tszz.customer.CustomerRepository;
import com.heu.poet.tszz.pet.Pet;
import com.heu.poet.tszz.pet.PetRepository;
import com.heu.poet.tszz.treasure.Treasure;
import com.heu.poet.tszz.treasure.TreasureRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@Service
public class TravelService {
    private Logger logger = Logger.getLogger("com.heu.poet.tszz.travel");
    private final String DATATIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private TravelRepository travelRepository;
    private PetRepository petRepository;
    private CustomerRepository customerRepository;
    private TreasureRepository treasureRepository;
    private String rootPath = System.getProperty("user.dir");

    @Autowired
    public TravelService(TravelRepository travelRepository, PetRepository petRepository,
                         CustomerRepository customerRepository, TreasureRepository treasureRepository) {
        this.travelRepository = travelRepository;
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
        this.treasureRepository = treasureRepository;
    }


    public List<Travel> findTravelsByUserId(String userId, int pageNum) {
        List<Travel> list = new ArrayList<>();
        PageRequest pageRequest = buildPageRequest(pageNum, 10, "startTimestamp");
        Page<Travel> res = travelRepository.findTravelsByUserId(userId, pageRequest);
        res.forEach(list::add);
        return list;
    }

    /**
     * * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;

        sort = new Sort(Sort.Direction.DESC, sortType);

        //参数1表示当前第几页,参数2表示每页的大小,参数3表示排序
        return PageRequest.of(pageNumber, pageSize, sort);
    }

    public Travel save(Travel travel) {
        System.out.println(travel.getPetId());
        return travelRepository.save(travel);
    }

    public Travel add(Travel travel) throws InterruptedException {
        DateTime dateTime = new DateTime();
        travel.setStartTime(dateTime.toString(DATATIME_FORMAT));
        travel.setStartTimestamp(dateTime.getMillis());
        List<String> logs = travel.getLogs();
        if (logs == null) {
            logs = new ArrayList<>();
        }

        travel.setLogs(logs);
        travel = travelRepository.insert(travel);
        String id = travel.getId();
        String petId = travel.getPetId();
        Pet pet = petRepository.findPetById(petId);
        pet.setStatusCode(1);
        pet.setTravelingId(id);
        petRepository.save(pet);
        String userId = pet.getUserId();
        Customer customer = customerRepository.findCustomerById(userId);
        List<Pet> pets = customer.getPets();
        int pos = -1;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId().equals(petId)) {
                pos = i;
                break;
            }
        }
        pets.set(pos, pet);
        customer.setPets(pets);
        customerRepository.save(customer);
        TravelThread travelThread = new TravelThread(travel);
        travelThread.join();
        travelThread.start();
        return travel;
    }


    class TravelThread extends Thread {

        private Travel travel;

        TravelThread(Travel travel) {
            this.travel = travel;
        }

        @Override
        public void run() {
            logger.log(Level.INFO, "start travel");

            int n = travel.getFishNumber();
            int m = n / 2;
            while (n > 0) {
                try {
                    n--;
                    if (n == 0) {
                        DateTime dateTime = new DateTime();
                        travel.setEndTime(dateTime.toString(DATATIME_FORMAT));
                        travel.setEndTimestamp(dateTime.getMillis());
                    }
                    logger.log(Level.INFO, "还剩" + n + "次");
                    findTreasure(travel.getStarNumber());
                    Thread.sleep(60 * 1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            while (m > 0) {
                m--;
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            travel.setStatusCode(1);
            String petId = travel.getPetId();
            Pet pet = petRepository.findPetById(petId);
            String userId = pet.getUserId();
            pet.setStatusCode(0);
            pet.setTravelingId("");
            Customer customer = customerRepository.findCustomerById(userId);
            List<Pet> pets = customer.getPets();
            int pos = -1;
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).getId().equals(petId)) pos = i;
            }
            pets.set(pos, pet);
            customer.setPets(pets);
            customerRepository.save(customer);
            petRepository.save(pet);
            DateTime end = new DateTime();
            travel.setEndTimestamp(end.getMillis());
            travel.setEndTime(end.toString(DATATIME_FORMAT));
            travelRepository.save(travel);
            logger.log(Level.INFO, "end travel");
        }

        private void findTreasure(int starNumber) {
            Random random = new Random();
            starNumber = starNumber >= 10 ? 10 : starNumber + 1;
            int n = random.nextInt(100) + 1;
            if (n < starNumber) {
                List<Treasure> treasures = treasureRepository.findAll();
                int size = treasures.size();
                int i = random.nextInt(size);
                Treasure treasure = treasures.get(i);
                List<String> logs = travel.getLogs();
                logs.add(travel.getPetName() + "发现了：" + treasure.getTypeName());
                logger.log(Level.INFO, travel.getPetName() + "发现了：" + treasure.getTypeName());
                List<Treasure> travelTreasures = travel.getTreasures();
                if (travelTreasures == null) travelTreasures = new ArrayList<>();
                travelTreasures.add(treasure);
                travel.setTreasures(travelTreasures);
                travel.setLogs(logs);
                String petId = travel.getPetId();
                Pet pet = petRepository.findPetById(petId);
                String userId = pet.getUserId();
                Customer user = customerRepository.findCustomerById(userId);
                List<Treasure> userTreasures = user.getTreasures();
                boolean flag = true;
                for (Treasure t : userTreasures) {
                    if (t.getId().equals(treasure.getId())) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    userTreasures.add(treasure);
                    user.setTreasures(userTreasures);
                    customerRepository.save(user);
                }
                travelRepository.save(travel);
            }
        }

    }


}

