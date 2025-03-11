package com.wannabeWhatsapp.demo.ui;

import com.wannabeWhatsapp.demo.model.User;
import com.wannabeWhatsapp.demo.model.Message;
import com.wannabeWhatsapp.demo.service.UserService;
import com.wannabeWhatsapp.demo.service.MessageService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("")
public class MainView extends VerticalLayout {
    private final UserService userService;
    private final MessageService messageService;

    private Grid<User> userGrid = new Grid<>(User.class);
    private Grid<Message> messageGrid = new Grid<>(Message.class);
    private TextField usernameField = new TextField("Benutzername");
    private TextField phoneNumberField = new TextField("Phonenumber");
    private Button addUserButton = new Button("Benutzer erstellen");

    public MainView(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;

        addUserButton.addClickListener(e -> createUser());

        userGrid.setItems(userService.getAllUsers());
        messageGrid.setItems(messageService.getMessagesBetweenUsers("User1", "User2"));

        add(usernameField, phoneNumberField, addUserButton, userGrid, messageGrid);
    }

    // TODO: typ sicherstellung (nummer -> keine buchstaben...)
    private void createUser() {
        String username = usernameField.getValue();
        String phoneNumber = phoneNumberField.getValue();
        if (!username.isEmpty() && !phoneNumber.isEmpty()) {
            User user = new User(username, false, phoneNumber);
            userService.createUser(user);
            userGrid.setItems(userService.getAllUsers());
            usernameField.clear();
        }
    }
}
