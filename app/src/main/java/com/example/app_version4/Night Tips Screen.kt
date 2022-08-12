package com.example.app_version4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_version4.ui.theme.DarkBlue

@Composable
fun NightTipsScreen(
    navController: NavController
) {
    LazyColumn(
        contentPadding = PaddingValues(start = 15.dp, end = 15.dp, bottom = 85.dp, top = 15.dp)
    ){
        item {
            Text(
                text = "Nine Tips for Walking Alone at Night",
                fontSize = 20.sp,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        item {
            DisplayTip(
                title = "1) Plan Your Route",
                content = "Make sure you plan your route ahead of time. If you are walking in an area you are not familiar with, this can help keep you from getting lost. You will be able to walk with confidence. If you do get lost, don’t wander aimlessly, find a gas station, supermarket, or fast-food restaurant where you can ask for directions."
            )
        }

        item {
            DisplayTip(
                title = "2) Make Sure Someone Else Knows Your Plans",
                content = "Don’t go out when it is dark without telling someone, even if you are just taking the dogs out for a walk around your neighborhood or walking home from a friend’s house nearby. It may seem paranoid, but in fact, knowing someone knows where you are can be reassuring and help you feel safe. If you fall and hurt yourself or run into trouble, and someone knows where you are, they can send help if you don’t arrive at your destination on time."
            )
        }

        item {
            DisplayTip(
                title = "3) Always Carry Your Phone with You",
                content = "Always carry your phone, but not for music or to make social calls as your walk. Your phone can be a lifeline if you see something suspicious or worse if something happens to you. If you feel threatened or see something suspicious, you can use contact security or your emergency contact person by pressing the button below"
            )
        }

        item {
            DisplayTip(
                title = "4) Avoid Suspicious People and Areas",
                content = "Areas that are dark, deserted, or out-of-the-way, such as an alley or a parking lot, can be riskier than a well-lit area full of people. Stick to busy, lighted paths, to minimize the risks. Also, walk mainly in familiar places where you are known. That way, if you feel like a suspicious person is following you, you can always duck into a store you know or knock on a neighbor’s door. Avoid empty streets and walkways with thick shrubbery."
            )
        }

        item {
            DisplayTip(
                title = "5) Keep Your Hands Free",
                content = "Except for a flashlight and one of the items discussed below, keep your hands free. If you are carrying anything, put it all in one bag or backpack. This will make it easier for you to react if you notice someone following you. In a dangerous situation, carrying too many bags can keep you from moving as quickly as you can if your hands are free or if you only have one bag.")
        }

        item {
            DisplayTip(
                title = "6) Carry a Non-Violent Deterrent",
                content = "In addition to a flashlight, carry a non-violent deterrent such as a whistle, mace, or pepper spray. A whistle will help you alert others and call them to aid you if something is wrong. The loud noise may put off attackers, and they’ll move on to find someone else. Mace or pepper spray can give you enough time to evade a potential attacker, and in a pinch, a flashlight can be used as a weapon. Make sure you know how to use the mace or pepper spray to get its full effect."
            )
        }

        item {
            DisplayTip(
                title = "7) Wear Reflective Clothing to Prevent Accidents",
                content = "When it comes to personal safety, it’s not just about suspicious people. Areas with low visibility can be prone to accidents. Reflective clothing allows bikers and cars to see you as you walk along. A flashlight or headlight can also help drivers see you if there are dark stretches of road on your route."
            )
        }

        item {
            DisplayTip(
                title = "8) Remove Any Distractions",
                content = "Keep your phone in your hand in case you need to hit the panic button on your safety app, but don’t let it distract you. When walking alone at night for exercise, music can be motivating and energizing but also distracting. You may not hear someone driving or walking up behind you. Avoid wearing headphones or talking on your phone as you walk."
            )
        }
        item {
            DisplayTip(
                title = "9) Trust Your Gut",
                content = "When walking alone at night, trust your gut. If you feel like an area or situation may be dangerous, don’t wait around to find out. Stop and scan your surroundings if you think someone is following you. If you are being followed, walk as quickly as you can to a well-lit public place. You can wait until you feel safe, or call a friend, a taxi, or an Uber to help you get safely get home at night"
            )
        }
        item {
            Text(
                text = "Source: https://www.saferwatchapp.com/blog/safety-tips-when-walking-alone-at-night/",
                fontSize = 13.sp
            )
        }
    }
}


@Composable
fun DisplayTip(
    title: String,
    content: String

) {
    Column(
        modifier = Modifier.padding(top = 15.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkBlue
        )
        Text(
            text = content,
            modifier = Modifier.padding(3.5.dp),
            lineHeight = 25.sp,
            fontSize = 17.sp
        )
    }

}