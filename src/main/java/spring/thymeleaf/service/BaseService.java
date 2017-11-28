package spring.thymeleaf.service;

import icon.treasury.entity.BalanceInformation;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by f.putra on 10/17/17.
 */
public interface BaseService<T> {

    T save(Map<String, Object> param);

    T update(Map<String, Object> param);

    T delete(Map<String, Object> param);

    T findById(Map<String, Object> param,  Long id);
}
