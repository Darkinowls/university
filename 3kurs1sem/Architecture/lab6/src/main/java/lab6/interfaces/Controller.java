package lab6.interfaces;

import lab6.models.Watch;

public interface Controller {

    public void setView(View view) ;

    public void setModel(Watch model);

    public Watch getModel();

    public View getView();
}
