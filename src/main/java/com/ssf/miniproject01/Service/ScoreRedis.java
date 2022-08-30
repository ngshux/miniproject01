package com.ssf.miniproject01.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ssf.miniproject01.Model.Data;

@Service
public class ScoreRedis implements ScoreRepo {
    
    @Autowired
    RedisTemplate<String, Data> redisTemplate;

    @Override
    public int save(final Data user){
        return 0;
    }

    @Override
    public int update(final Data user){
        return 0;
    }

    public Data[] getAllScores(){
        Set<String> allScores = redisTemplate.keys("*");
        List<Data> dArr = new LinkedList<Data>();
        for(String score : allScores){
            Data result = (Data) redisTemplate.opsForValue().get(score);
            dArr.add(result);
        }

        return dArr.toArray(new Data[dArr.size()]);
    }
}
