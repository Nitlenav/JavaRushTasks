package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class SubscriptAction extends StyledEditorKit.StyledTextAction {

    public SubscriptAction (){
super(StyleConstants.Subscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSubscript(simpleAttributeSet, !StyleConstants.isSubscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
