package pe.idat.quesosapp_2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BienvenidaScreen() {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.logo_quesos_express),
                    contentDescription = "Logo de Quesos Express",
                    modifier = Modifier
                        .size(320.dp)
                        .align(Alignment.TopCenter).padding(top = 180.dp)
                )

                Text(
                    text = "Bienvenido a la app de Quesos Express",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 16.dp)
                )

                Button(
                    onClick = { /* Acción al comenzar el pedido */ },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                ) {
                    Text("Comenzar pedido")
                }
            }
        }

