package project.interfaces;

import project.model.MyData;
import project.model.MyTime;

public interface View {

    public void printData(IWatch data);
    public void printTime(IWatch time);
    public void printAll(IWatch time);

}
