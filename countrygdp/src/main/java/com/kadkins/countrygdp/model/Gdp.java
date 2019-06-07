package com.kadkins.countrygdp.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.IntFunction;

public class GDP extends ArrayList<GDP>
{
    private static AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private String gdp;

    public GDP(String name, String gdp)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.gdp = gdp;
    }

    public GDP() {

    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGdp()
    {
        return gdp;
    }

    public void setGdp(String gdp)
    {
        this.gdp = gdp;
    }

    @Override
    public String toString()
    {
        return "GDP{" + "id=" + id + ", name='" + name + '\'' + ", gdp='" + gdp + '\'' + '}';
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator)
    {
        return null;
    }
}
