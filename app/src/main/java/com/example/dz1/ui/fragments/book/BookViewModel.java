package com.example.dz1.ui.fragments.book;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dz1.R;
import com.example.dz1.data.ModelClient;
import com.example.dz1.model.Model;

import java.util.ArrayList;
import java.util.List;


public class BookViewModel extends ViewModel {
    ModelClient client = new ModelClient();

    public MutableLiveData<List<Model>> mutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Model> list = new MutableLiveData<>();

    public void getBookList() {
        List<Model> list = new ArrayList<>();
        list.add(new Model("ОРУЭЛЛ", "description1", R.drawable.book1));
        list.add(new Model("Записки юного врача", "description2", R.drawable.book2));
        list.add(new Model("НИ СЫ", "description3", R.drawable.book3));
        list.add(new Model("НЕ ТУ ПИ", "description4", R.drawable.book4));
        mutableLiveData.setValue(list);
    }

    public void fetch() {
        mutableLiveData.setValue(client.getData());
    }

    public MutableLiveData<Model> getBooks() {
        return list;
    }
}
