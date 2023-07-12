package com.tech.composelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tech.composelearn.model.User
import com.tech.composelearn.model.dummyData
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class RecyclerViewActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                RecyclerView(users = dummyData())
            }
        }
    }

    @Composable
    fun EachRow(user : User){
        Card(modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)), elevation = CardDefaults.cardElevation(2.dp) ) {

            Row(modifier = Modifier.padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.compose), contentDescription = "compose",
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
                )
                Text(text = user.description,modifier = Modifier.padding(8.dp))
            }
        }
    }
    @Composable
    fun RecyclerView(users : List<User>){
        LazyColumn {
            items(users){user->
                EachRow(user)
            }
        }
    }


}