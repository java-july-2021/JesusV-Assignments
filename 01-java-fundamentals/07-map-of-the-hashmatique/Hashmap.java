import java.util.ArrayList;
import java.util.Hashmaps;
import java.util.Arrays;

public class Hashmaps{
    public static void main(String[]args){
        HashMap<String,String> trackList = new HashMap<String,String>();
        trackList.put("Til I Collapse", "'Cause sometimes you just feel tired, feel weak And when you feel weak You feel like you wanna just give up But you gotta search within you Try to find that inner strength And just pull that shit out of you And get that motivation to not give up And not be a quitter, no matter how bad you wanna just fall Flat on your face and collapse")
        trackList.put("Middle Child", "I'm all in my bag, this hard as it get I do not snort powder, I might take a sip I might hit the blunt, but I'm liable to trip I ain’t poppin' no pill, but you do as you wish I roll with some fiends, I love 'em to death I got a few mil' but not all of them rich What good is the bread if my n***** is broke? What good is first class if my n***** can't sit? That's my next mission, that's why I can't quit")
        trackList.put("I'm Not Racist", "I'm not racist, but I cry a lot You don't know what it's like to be in a frying pot You don't know what it's like to mind your business And get stopped by the cops and not know if you 'bout to die or not You worry 'bout your life, so you take mine I love you, but I fuckin' hate you at the same time I wish we could trade shoes or we could change lives So we could understand each other more, but that'd take time")
        trackList.put("Ramen & OJ", "I can never go back to the old days, no way Back to walkin' to work on a cold day Back to thinkin' my ex was my soulmate Back to tellin' myself, We'll be okay, we'll be okay Was survivin' off of ramen and OJ I was payin' them bills, I had no say I can never go back to the bottom, to the bottom Sellin' drugs, never know when the cops come N***** jealous, they wanted to rob us I was just trying to get me some dollars, couple dollars Turned my pennies from hundreds to commas I'm so happy them days are behind us")
    
        String song = trackList.get("Ramen % OJ");

        for(HashMap.Entry<String, String> entry: trackList.entrySet()){
            System.out.println(String.format("Track: %s: Lyrics: %s", key, map.get(song)));
        }
    
    }


}