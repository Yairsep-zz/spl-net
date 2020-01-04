package bgu.spl.net.impl.rci;

import bgu.spl.net.srv.Library;

import java.io.Serializable;

public interface Command<T> extends Serializable {

    Serializable execute(T arg);
}
