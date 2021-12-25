package project.interfaces;

import project.models.Watch;

public interface Controller {

    public void setView(View view) ;

    public void setModel(Watch model);

    public Watch getModel();

    public View getView();
}
