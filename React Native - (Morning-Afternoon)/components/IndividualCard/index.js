import React from "react";
import { TouchableOpacity, View, Text } from "react-native";
import AsyncStorage from '@react-native-community/async-storage';
const NoteCard = ({ noteData, navigation }) => {

    const deleteCard = async (id) => {


        console.log("delete card", id);
        let currentList = JSON.parse(await AsyncStorage.getItem("notesList"));
        console.log("the current list is", currentList);

        for (var i in currentList) {
            console.log(i, id, currentList[i].id)
            if (currentList[i].id == id) {
                currentList.splice(parseInt(i), 1);

            }
        }
        await AsyncStorage.setItem("notesList", JSON.stringify(currentList));
        console.log("done");
        currentList = JSON.parse(await AsyncStorage.getItem("notesList"));

        console.log(currentList)
        navigation.reset({
            index: 0,
            routes: [{ name: "view-notes" }],
        });
    }

    return (
            <View style={{borderBottomColor: 'black', borderBottomWidth: 1}}>
                <Text style={{ fontWeight: "bold" }}> {noteData.id}. </Text>
                <Text style={{ fontWeight: "bold" }}>Title:{noteData.note.title} </Text>
                <Text style={{ fontWeight: "bold" }}>Description: {noteData.note.description} </Text>
                <TouchableOpacity onPress={() => deleteCard(noteData.id)}>
                    <Text style={{ color: "red", fontWeight: "bold", borderColor:"red", borderWidth: 2, width: "28%" }}>Delete Note</Text>
                </TouchableOpacity>
            </View>
    );
}

export default NoteCard;