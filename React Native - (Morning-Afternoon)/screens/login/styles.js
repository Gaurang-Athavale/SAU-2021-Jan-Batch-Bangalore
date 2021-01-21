import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
        flex: 1,
        // height: "100%",
        justifyContent: "center",
        // alignSelf: "center",
        marginLeft: "10%"
    },
    button: {
        borderWidth: 1,
        width: "90%",
        height: 40,
        justifyContent: "center",
        alignItems: "center",
        borderRadius: 10,
        borderColor: "black",
        backgroundColor: "blue"      
    },
    input: {
        borderWidth: 1,
        height: 40,
        width: "90%",
        alignItems: 'center',
        justifyContent: 'center',
        paddingHorizontal: 10,
        borderRadius: 10,
        borderColor: "blue",
        backgroundColor: "white"      
    }
});

export default styles;