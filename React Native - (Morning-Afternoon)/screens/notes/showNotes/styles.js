import { StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const styles = StyleSheet.create({
    container: {
        flex: 1,
        height: Dimensions.get("window").height,
    },
    button: {
        borderWidth: 1,
        width: "90%",
        height: 40,
        justifyContent: "center",
        alignItems: "center",
        borderRadius: 10,
        borderColor: "black",
        backgroundColor: "blue" ,
        color: "white",
        marginBottom: 20,
        marginLeft: "5%",
        paddingHorizontal: "35%",
        paddingVertical: "2%"
    },
    scrollView: {
        marginBottom: Dimensions.get("window").height * 0.01
    }
});

export default styles;