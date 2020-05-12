package project.service.impl;

import project.bootstrap.DataHolder;
import project.model.Bread;
import project.service.BreadService;

import java.util.List;

public class BreadServiceImpl implements BreadService {

    @Override
    public List<Bread> listBreads() {
        return DataHolder.breads;
    }

    @Override
    public Bread getById(String name) {
        return null;
    }
}
