package org.innopolis.javaEE.userStatPart.model.services.interfaces;

import org.innopolis.javaEE.userStatPart.model.Stat;

import java.sql.SQLException;

public interface StatService {
//    Stat getUserStat(Stat stat) throws ServiceException;
    Stat getStatByUserId(Integer id) throws SQLException;
}
