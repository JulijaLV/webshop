package com.github.julijalv.webshop.ui;

import com.github.julijalv.webshop.backend.Product;
import com.github.julijalv.webshop.repository.ProductRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {


    @Autowired
    private ProductRepository productRepository;
    private Grid<Product> productGrid = new Grid<>(Product.class, false);

    private ProductForm createProductForm(Grid<Product> grid, Product product) {
        return new ProductForm(product);
    }

    private void configureGrid() {
        productGrid.addClassName("product-grid");
        productGrid.setSizeFull();
    }

    private void updateList() {
        productGrid.setItems(productRepository.getProducts());
        productGrid.addComponentColumn(item -> createProductForm(productGrid, item));
    }
    public MainView(ProductRepository productRepository) {
        this.productRepository = productRepository;

        Icon drawer = VaadinIcon.MENU.create();
        Span title = new Span("Ze Shopping");
        HorizontalLayout header = new HorizontalLayout(drawer, title);
        header.expand(title);
        header.setPadding(true);
        header.setWidth("100%");
        add(header);


        addClassName("product-view");
        setSizeFull();
        configureGrid();

        add(productGrid, new CartView());
        updateList();







//        add(new Text("Helljo"));
//        Button button = new Button("Vaadin button");
//
//        button.addClickListener(clickEvent -> this.addToCart());
//        add(button);

//        List<Product> productList =
//        form = new ProductForm();
//        add(form);

//        addToCart();
////        shoppingCartRepository.addItem();
//        MenuBar menuBar = new MenuBar();
//        Text selected = new Text("");
//        Div message = new Div(new Text("Selected: "), selected);
//
//        MenuItem project = menuBar.addItem("Project");
//        MenuItem account = menuBar.addItem("Account");
//        menuBar.addItem("Sign Out", e -> selected.setText("Sign Out"));
//
//        SubMenu projectSubMenu = project.getSubMenu();
//        MenuItem users = projectSubMenu.addItem("Users");
//        MenuItem billing = projectSubMenu.addItem("Billing");
//
//        SubMenu usersSubMenu = users.getSubMenu();
//        usersSubMenu.addItem("List", e -> selected.setText("List"));
//        usersSubMenu.addItem("Add", e -> selected.setText("Add"));
//
//        SubMenu billingSubMenu = billing.getSubMenu();
//        billingSubMenu.addItem("Invoices", e -> selected.setText("Invoices"));
//        billingSubMenu.addItem("Balance Events",
//                e -> selected.setText("Balance Events"));
//
//        account.getSubMenu().addItem("Edit Profile",
//                e -> selected.setText("Edit Profile"));
//        account.getSubMenu().addItem("Privacy Settings",
//                e -> selected.setText("Privacy Settings"));
//        add(menuBar, message);
////        add(new Text("Helljo"));
    }
}
