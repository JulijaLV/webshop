package com.github.julijalv.webshop.ui;

import com.github.julijalv.webshop.repository.ShoppingCartRepository;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.NumberField;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductForm extends FormLayout {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ProductForm( String name, String description) {
        addClassName("product-form");
        add(createHeader(name, description));
    }

    private VerticalLayout createHeader(String name, String description) {
        Text itemName = new Text(name);
        Text itemDescr = new Text(description);
//        itemDescr.setReadOnly(true);
//        itemName.setReadOnly(true);
        add(itemName);
        add(itemDescr);
        return new VerticalLayout(itemName, itemDescr, createFooter());
    }
    private HorizontalLayout createFooter() {
        NumberField qtyField = new NumberField();
        qtyField.setHasControls(true);
        qtyField.setMin(0);
        qtyField.setMax(10);
        qtyField.setStep(1);
        Button addBtn = new Button("Add");
        addBtn.addClickListener(clickEvent -> this.addToCart());
        add(qtyField);
        addBtn.addThemeVariants(ButtonVariant.LUMO_SMALL);
        return new HorizontalLayout(qtyField, addBtn);
    }

    public void addToCart() {
        shoppingCartRepository.addItem();
    }
}
