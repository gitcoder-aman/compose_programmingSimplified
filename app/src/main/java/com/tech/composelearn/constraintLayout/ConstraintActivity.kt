package com.tech.composelearn.constraintLayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class ConstraintActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                ConstraintUI()
            }
        }
    }
}

@Composable
fun ConstraintUI() {

    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

        val (box1, box2, box3) = createRefs()

        Box(modifier = Modifier
            .size(150.dp)
            .background(Color.Red)
            .constrainAs(box1) {

            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(box2) {

            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Black)
            .constrainAs(box3) {

            })
    }
}


@Composable
fun ArrangeHorizontally() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val (text1, text2, text3) = createRefs()

        Text(text = "Text One", modifier = Modifier.constrainAs(text1) {
            start.linkTo(parent.start, margin = 20.dp)
            top.linkTo(parent.top)
        })
        Text(text = "Text Two", modifier = Modifier.constrainAs(text2) {
            top.linkTo(text1.bottom, margin = 20.dp)
            start.linkTo(text1.start)
        })
        Text(text = "Text Three", modifier = Modifier.constrainAs(text3) {
            top.linkTo(text2.bottom, margin = 20.dp)
            start.linkTo(text2.start)
        })
    }
}

@Composable
fun LoginPageWithConstraintLayout() {

    var username1 by remember {
        mutableStateOf("")
    }
    var password1 by remember {
        mutableStateOf("")
    }
    val constraints = ConstraintSet {
        val username = createRefFor("username")
        val password = createRefFor("password")
        val button = createRefFor("button")

        constrain(username) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }

        constrain(password) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(username.bottom, margin = 10.dp)
        }

        constrain(button) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(password.bottom, margin = 10.dp)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout(constraintSet = constraints) {
            TextField(value = username1, onValueChange = {
                username1 = it
            }, modifier = Modifier.layoutId("username"))

            TextField(
                value = password1,
                onValueChange = {
                    password1 = it
                },
                modifier = Modifier.layoutId("password"),
                visualTransformation = PasswordVisualTransformation()
            )
            Button(onClick = { /*TODO*/ }, modifier = Modifier.layoutId("button")) {
                Text(text = "Login")
            }
        }
    }
}

@Composable
fun GuidelineExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (text1) = createRefs()
        val createGuideTop = createGuidelineFromTop(40.dp)
        Text(text = "Some Content", modifier = Modifier.constrainAs(text1) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(createGuideTop)
        })
    }
}

@Composable
fun CreateBarrierExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(30.dp)
    ) {
        val (text1, text2, text3) = createRefs()

        val barrierEnd = createEndBarrier(
            text1, text2
        )

        Text(text = "text one contents", modifier = Modifier.constrainAs(text1) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        })

        Text(text = "text two contents", modifier = Modifier.constrainAs(text2) {
            start.linkTo(parent.start)
            top.linkTo(text1.bottom)
        })
        Text(text = "text three contents", modifier = Modifier.constrainAs(text3) {
            start.linkTo(barrierEnd)
            top.linkTo(text1.bottom)
        })
    }
}

@Composable
@Preview
fun CreateChainExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        val (text1, text2, text3) = createRefs()

        createVerticalChain(text1, text2, text3, chainStyle = ChainStyle.SpreadInside)

        Text(text = "text1", modifier = Modifier.constrainAs(text1) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        })

        Text(text = "text2", modifier = Modifier.constrainAs(text2) {
            start.linkTo(text1.end)
            top.linkTo(text1.top)
            bottom.linkTo(text1.bottom)
        })

        Text(text = "text3", modifier = Modifier.constrainAs(text3) {
            start.linkTo(text2.end)
            top.linkTo(text2.top)
            bottom.linkTo(text2.bottom)
        })
    }
}
