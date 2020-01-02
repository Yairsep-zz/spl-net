package bgu.spl.net.srv;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Library {

    private ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> channels = new ConcurrentHashMap<>();


}
