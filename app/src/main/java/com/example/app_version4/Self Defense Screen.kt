package com.example.app_version4

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_version4.ui.theme.Blue
import com.example.app_version4.ui.theme.DarkBlue


@Composable
fun SelfDefense(
    navController: NavController
) {
    LazyColumn(
        contentPadding = PaddingValues(start = 15.dp, end = 15.dp, bottom = 85.dp, top = 15.dp)
    ){
        item {
            Text(
                text = "Eight Self Defense Moves for Women",
                fontSize = 20.sp,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }


        item {
            DisplayOddMove1(
                title = "1. Hammer strike",
                text = listOf(
                    "Using your car keys is one of the easiest ways to defend yourself. Don’t use your fingernails, because you’re more at risk to injure your hands.",
                    "Instead, if you feel unsafe while walking at night, have your keys stick out from one side of your fist for hammer strikes."
                ),
                gif1 = R.drawable.move1a,
                alternative = "Another way to use your keys is to click them onto a lanyard to swing at your attacker.",
                gif2 = R.drawable.move1b,
                steps = listOf(
                    "Hold your key ring in a tight fist, like holding a hammer, with keys extending from the side of your hand.",
                    "Thrust downward toward your target."
                )
            )
        }

        item {
            DisplayMove(
                title = "2. Groin kick",
                text = listOf(
                    "If someone is coming at you from the front, a groin kick may deliver enough force to paralyze your attacker, making your escape possible.",
                ),
                steps = listOf(
                    "Stabilize yourself as best you can.",
                    "Lift your dominant leg off the ground and begin to drive your knee upward.",
                    "Extend your dominant leg, drive hips forward, slightly lean back, and kick forcefully, making contact between your lower shin or ball of your foot and the attacker’s groin area.",
                    "Alternative: If your attacker is too close, thrust your knee toward the groin. Make sure you’re stabilized and not at risk of falling over."
                ),
                gif = R.drawable.move2
            )
        }

        item {
            DisplayMove(
                title = "3. Heel palm strike",
                text = listOf(
                    "This move can cause damage to the nose or throat. To execute, get in front of your attacker as much as is possible."
                ),
                steps = listOf(
                    "With your dominant hand, flex your wrist.",
                    "Aim for either the attacker’s nose, jabbing upward from the nostrils, or underneath the attacker’s chin, jabbing upward at the throat.",
                    "Make sure to recoil your strike. Pulling your arm back quickly will help thrust the attacker’s head up and back.",
                    "This will cause your attacker to stagger backward, allowing you to escape their grasp.",
                    "Alternative: An open palm to the ears can be very disorienting."
                ),
                gif = R.drawable.move3
            )
        }

        item {
            DisplayMove(
                title = "4. Elbow strike",
                text = listOf(
                    "If your attacker is in close range and you’re unable to get enough momentum to throw a strong punch or kick, use your elbows."
                ),
                steps = listOf(
                    "If you can, stabilize yourself with a strong core and legs to ensure a powerful blow.",
                    "Bend your arm at the elbow, shift your weight forward, and strike your elbow into your attacker’s neck, jawline, chin, or temple. These are all effective targets.",
                    "This may cause your attacker to loosen their grip, allowing you to run."
                ),
                gif = R.drawable.move4
            )
        }

        item {
            DisplayOddMove2(
                title = "5. Alternative elbow strikes",
                text = listOf(
                    "Depending on how you’re standing when you’re initially attacked, you may be in a better position for variations on the elbow strike."
                ),
                steps1 = listOf(
                    "Lift your elbow to shoulder height.",
                    "Pivot on same-side foot and allow your hips to rotate, creating more momentum into the front part of your elbow when you strike."
                ),
                steps2 = listOf(
                    "Make sure you see the target.",
                    "Bring your elbow up and pivot your opposite foot, rotating your hips and turning into the target, making contact with the back part of your elbow."
                ),
                gif = R.drawable.move5
            )
        }

        item {
            DisplayMove(
                title = "6. Escape from a ‘bear hug attack’",
                text = listOf(
                    "For cases where the attacker is coming from behind, you’ll want to use this move. Focus on getting low and creating space to free yourself."
                ),
                steps = listOf(
                    "Bend forward from the waist. This shifts your weight forward, making it more difficult for your attacker to pick you up. It also gives you a better angle to throw elbows from side to side to the attacker’s face.",
                    "Turn into the attacker with one of your elbows and continue counterattacking.",
                    "This should give you space to turn fully, using another move to injure the face or strike the groin. With the space these moves have created, you may be able to escape and run away."
                ),
                gif = R.drawable.move6
            )
        }

        item {
            DisplayMove(
                title = "7. Escape with hands trapped",
                text = listOf(
                    "If your attacker comes from behind and traps your arms (this is similar to a bear hug, but you won’t be able to move as freely, here’s what to do:"
                ),
                steps = listOf(
                    "First reaction should be to stop your attacker’s arms from going higher into a headlock. Shift your hips to one side. This gives an opening for strikes to the groin with open-handed slaps.",
                    "Bring your hand back up to your arms and raise your opposite elbow to turn into the wrap. Keep your arms tight to your chest as you’re turning in.",
                    "Stay aggressive with your knees and other counterattacks until you can disengage."
                ),
                gif = R.drawable.move7
            )
        }

        item {
            DisplayMove(
                title = "8. Escape from side headlock",
                text = listOf(
                    "When the attacker locks their arm around your head from the side, your first instinct should be to avoid getting choked."
                ),
                steps = listOf(
                    "Turn into the attacker’s side as much as possible to avoid being choked.",
                    "With your hand that’s furthest away, strike the groin with open-handed slaps until you have enough mobility to turn your head all the way out to disengage."
                ),
                gif = R.drawable.move8
            )
        }
        item {
            Text(
                text = "Source: https://www.healthline.com/health/womens-health/self-defense-tips-escape#protection-alternatives",
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun DisplayOddMove1(
    title: String,
    text: List<String>,
    @DrawableRes gif1: Int,
    alternative: String,
    @DrawableRes gif2: Int,
    steps: List<String>

) {
    Column(
        modifier = Modifier
            .padding(top = 15.dp)
            .border(width = 3.dp, color = Blue, shape = RoundedCornerShape(7)
            )
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkBlue,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        for (paragraph in text){
            Text(
                text = paragraph,
                modifier = Modifier.padding(5.dp),
                lineHeight = 25.sp,
                fontSize = 17.sp,
            )
        }

        CoilImage(gif1)
        Text(
            text = alternative,
            lineHeight = 25.sp,
            fontSize = 17.sp,
            modifier = Modifier.padding(5.dp)
        )
        CoilImage(gif2)
        Text(
            text = "To perform",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 7.dp)
        )
        DisplaySteps(steps = steps)
    }

}

@Composable
fun DisplayMove(
    title: String,
    text: List<String>,
    steps: List<String>,
    @DrawableRes gif: Int

) {
    Column(
        modifier = Modifier.padding(top = 15.dp).border(width = 3.dp, color = Blue, shape = RoundedCornerShape(7))
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkBlue,
            modifier = Modifier.padding(horizontal = 15.dp),
        )
        for (paragraph in text){
            Text(
                text = paragraph,
                modifier = Modifier.padding(5.dp),
                lineHeight = 25.sp,
                fontSize = 17.sp
            )
        }
        CoilImage(gif)

        Text(
            text = "To perform",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 7.dp)
        )
        DisplaySteps(steps = steps)

    }
}


@Composable
fun DisplayOddMove2(
    title: String,
    text: List<String>,
    steps1: List<String>,
    steps2: List<String>,
    @DrawableRes gif: Int

) {
    Column(
        modifier = Modifier.padding(top = 15.dp).border(width = 3.dp, color = Blue, shape = RoundedCornerShape(7))
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkBlue,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        for (paragraph in text){
            Text(
                text = paragraph,
                modifier = Modifier.padding(5.dp),
                lineHeight = 25.sp,
                fontSize = 17.sp
            )
        }
        CoilImage(gif)
        Text(
            text = "To perform from the front:",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 7.dp)
        )
        DisplaySteps(steps = steps1)

        Text(
            text = "To perform from the side and back:",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 7.dp)
        )

        DisplaySteps(steps = steps2)
    }
}

@Preview
@Composable
fun SD() {
    val navController = rememberNavController()
    SelfDefense(navController = navController)

}
