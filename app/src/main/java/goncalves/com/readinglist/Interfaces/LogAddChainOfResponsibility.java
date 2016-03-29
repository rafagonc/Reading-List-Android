package goncalves.com.readinglist.Interfaces;

import goncalves.com.readinglist.Entities.Abstract.Log;

/**
 * Created by rafagonc on 3/25/16.
 */
public interface LogAddChainOfResponsibility {

    public void processLog(Log log) throws Exception;

}
