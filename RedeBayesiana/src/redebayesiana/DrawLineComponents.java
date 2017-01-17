/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redebayesiana;

import java.awt.Component;

/**
 *
 * @author david
 */
public class DrawLineComponents {
    Component comp1;
    Component comp2;

    public DrawLineComponents(Component comp1, Component comp2) {
        this.comp1 = comp1;
        this.comp2 = comp2;
    }

    
    
    public Component getComp1() {
        return comp1;
    }

    public void setComp1(Component comp1) {
        this.comp1 = comp1;
    }

    public Component getComp2() {
        return comp2;
    }

    public void setComp2(Component comp2) {
        this.comp2 = comp2;
    }
    
    
}
