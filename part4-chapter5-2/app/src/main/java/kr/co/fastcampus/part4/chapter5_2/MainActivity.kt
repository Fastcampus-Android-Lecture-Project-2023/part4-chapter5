package kr.co.fastcampus.part4.chapter5_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.fastcampus.part4.chapter5_2.ui.theme.ViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopLevel()
                }
            }
        }
    }
}

@Composable
fun TopLevel() {
    val (text, setText) = remember { mutableStateOf("") }
    val toDoList = remember { mutableStateListOf<ToDoData>() }

    val onSubmit: (String) -> Unit = {
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
        toDoList.add(ToDoData(key, it))
        setText("")
    }

    val onEdit: (Int, String) -> Unit = { key, newText ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList[i] = toDoList[i].copy(text = newText)
    }

    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList[i] = toDoList[i].copy(done = checked)
    }

    val onDelete: (Int) -> Unit = { key ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList.removeAt(i)
    }

    Scaffold {
        Column {
            ToDoInput(text, setText, onSubmit)
            LazyColumn {
                items(
                    items = toDoList,
                    key = { it.key }
                ) { toDoData ->
                    ToDo(toDoData, onEdit, onToggle, onDelete)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViewModelTheme {
        TopLevel()
    }
}

@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    ViewModelTheme {
        ToDoInput("테스트", {}, {})
    }
}

@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp
    ) {
        Crossfade(
            targetState = isEditing,
        ) {
            when (it) {
                false -> {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = toDoData.text,
                            modifier = Modifier.weight(1f)
                        )
                        Text("완료")
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { checked ->
                                onToggle(toDoData.key, checked)
                            }
                        )
                        Button(
                            onClick = { isEditing = true }
                        ) {
                            Text("수정")
                        }
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(
                            onClick = { onDelete(toDoData.key) }
                        ) {
                            Text("삭제")
                        }
                    }
                }
                true -> {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val (text, setText) = remember { mutableStateOf(toDoData.text) }
                        OutlinedTextField(
                            value = text,
                            onValueChange = setText,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Button(onClick = {
                            isEditing = false
                            onEdit(toDoData.key, text)
                        }) {
                            Text("완료")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ViewModelTheme {
        ToDo(ToDoData(1, "nice", true))
    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)