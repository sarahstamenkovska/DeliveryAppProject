package project.service;

import project.model.Bread;

import java.util.List;

public interface BreadService {

    List<Bread> listBreads();
    Bread getById(String name);
}
