import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Box, Button, List, ListItem, ListItemText, Typography } from "@mui/material";

function ChatList(){
    const [chats] = useState(["Max Mustermann", "Maxime Musterfrau"]);
    const navigate = useNavigate();

    const handleLogout = () => {
        localStorage.removeItem("token");
        navigate("/login");
    };

    return (
        <Box sx={{ width: "30%", height: "100vh", borderRight: "1px solid #ccc", p: 2 }}>
            <Button variant="contained" fullWidth sx={{ mb: 2 }}>
                + Neuer Chat
            </Button>
            <Typography variant="h6" gutterBottom>
                Chats
            </Typography>
            <List>
                {chats.map((chat, index) => (
                    <ListItem key={index} component="button">
                        <ListItemText primary={chat} />
                    </ListItem>
                ))}
            </List>
        </Box>
    );
}

export default ChatList;
