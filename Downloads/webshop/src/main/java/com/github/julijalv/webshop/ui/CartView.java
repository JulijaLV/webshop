package com.github.julijalv.webshop.ui;

import com.github.julijalv.webshop.repository.ShoppingCartRepository;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

public class CartView extends VerticalLayout {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public CartView(){
        addClassName("cart-form");
        add(createCartView());
    }

    Icon cartIcon = VaadinIcon.CART.create();

    Text sum     = new Text("Sum:");
    private VerticalLayout createCartView() {

        VerticalLayout layout = new VerticalLayout();
        layout.add(cartIcon);
        layout.setSpacing(true);
        layout.setBoxSizing(BoxSizing.CONTENT_BOX);
        return layout;
    }



}
