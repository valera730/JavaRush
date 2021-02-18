package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.MoikrugStrategy;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;

public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Provider hhProvider = new Provider(new HHStrategy());
        Provider moikrugProvider = new Provider(new MoikrugStrategy());
        Model model = new Model(view, hhProvider, moikrugProvider);
        Controller controller = new Controller(model);

        view.setController(controller);
        view.userCitySelectEmulationMethod ();
    }
}