package com.github.julijalv.webshop.ui;

import com.github.julijalv.webshop.backend.Product;
import com.github.julijalv.webshop.repository.ProductRepository;
import com.github.julijalv.webshop.repository.ShoppingCartRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Route
public class MainView extends VerticalLayout {

//    @Autowired
//    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductRepository productRepository;

    private ProductForm form;
    private Grid<Product> productGrid = new Grid<>(Product.class);



//    public
    private ProductForm createProductForm(Grid<Product> grid, Product item) {
        return new ProductForm(item.getId(), item.getDescription());
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
        addClassName("product-view");
        setSizeFull();
        configureGrid();
        add(productGrid);
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
