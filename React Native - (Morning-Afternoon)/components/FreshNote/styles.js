import { StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const styles = StyleSheet.create({
    container: {
        marginLeft:"10%",
        flex: 1
    },
    input:{
          borderWidth: 1,
        height: 40,
        width: "90%",
        alignItems: 'center',
        justifyContent: 'center',
        paddingHorizontal: 10,
        borderRadius: 10,
        borderColor: "blue",
        backgroundColor: "white"
    },
     header: {
        fontSize: 50
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
    
});

export default styles;