package org.mitratul.service;

public class TalkServiceImpl implements ITalkService {

    private String name;

    public TalkServiceImpl() {
        this ("World");
    }

    public TalkServiceImpl(String string) {
        name = string;
    }

    @Override
    public String sayHello() {
        return "Hello " + name;
    }

    @Override
    public String sayKelo() {
        return "What did you do to the " + name + "?";
    }

}
