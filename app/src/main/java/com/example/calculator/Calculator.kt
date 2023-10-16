package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.DarkGreen
import com.example.calculator.ui.theme.LightYellow

@Composable
fun Calculator(
    state : CalculatorState,
    modifier: Modifier = Modifier,
    onAction: (CalculatorOnAction) -> Unit
) {

    Box (modifier = modifier){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = state.inputString,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                fontWeight = FontWeight.Light,
                fontSize = 40.sp,
                color = Color.Black,
                maxLines = 3
            )

            Text(
                text = state.result,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                fontWeight = FontWeight.Light,
                fontSize = 70.sp,
                color = Color.Black,
                maxLines = 2
            )


            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "C",
                    modifier = Modifier
                        .background(LightYellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Clear)}

                )
                CalculatorButton(
                    symbol = "%",
                    modifier = Modifier
                        .background(LightYellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Operation(CalculatorOperation.Modulus))}

                )
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(LightYellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Delete)}

                )
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(LightYellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Operation(CalculatorOperation.Divide))}

                )
            }


            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(7))}

                )
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(8))}

                )
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(9))}

                )
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(LightYellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Operation(CalculatorOperation.Multiply))}

                )
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(4))}

                )
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(5))}

                )
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(6))}

                )
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(LightYellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Operation(CalculatorOperation.Subtract))}

                )
            }


            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(1))}

                )
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(2))}

                )
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(3))}

                )
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(LightYellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Operation(CalculatorOperation.Add))}

                )
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "00",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.DoubleZero)}

                )
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Number(0))}

                )
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(DarkGreen)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Decimal)}

                )
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(LightYellow)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorOnAction.Calculate)}

                )
            }



        }

    }

}
