package com.heu.poet.tszz.loginlogs;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi
 * @create 2018-02-24 09:53
 */
public interface LoginLogsRepository extends MongoRepository<LoginLogs,String> {
}
