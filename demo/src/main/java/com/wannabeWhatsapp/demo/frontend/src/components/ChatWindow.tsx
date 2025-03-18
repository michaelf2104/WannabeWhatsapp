import { Box, Typography } from "@mui/material";

const ChatWindow = () => {
    return (
        <Box sx={{ width: "70%", height: "100vh", p: 2 }}>
            <Typography variant="h5">Willkommen im Chat</Typography>
            <Typography variant="body1">Wähle einen Chat aus, um zu beginnen.</Typography>
        </Box>
    );
};

export default ChatWindow;
