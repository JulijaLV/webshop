package com.github.julijalv.webshop.ui;

import com.github.julijalv.webshop.backend.Product;
import com.github.julijalv.webshop.repository.ShoppingCartRepository;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductForm extends FormLayout {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
//    Binder<Product> binder = new BeanValidationBinder<>(Product.class);

    public ProductForm(Product prod) {
        addClassName("product-form");
        add(createHeader(prod.getName(), prod.getDescription()));
    }

    private VerticalLayout createHeader(String name, String description) {
        Text itemName = new Text(name);
        Text itemDescr = new Text(description);
        VerticalLayout layout = new VerticalLayout(itemName, itemDescr, createFooter());
        layout.setSpacing(true);
        layout.setBoxSizing(BoxSizing.CONTENT_BOX);
        return layout;
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
