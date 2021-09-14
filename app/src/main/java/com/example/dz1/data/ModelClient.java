package com.example.dz1.data;

import com.example.dz1.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelClient {
    private Model model;

    public List<Model> getData() {
        List<Model> data = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            data.add(data.set(i, model));
        }
        return data;
    }
}
