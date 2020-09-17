package org.ck.codeEval.easy.readMore;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "Tom exhibited.",
            "Amy Lawrence was proud and glad, and... <Read More>",
            "Tom was tugging at a button-hole and looking sheepish.",
            "Two thousand verses is a great many -... <Read More>",
            "Tom's mouth watered for the apple, but... <Read More>"),
        this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "123456789A123456789B123456789C123456789D... <Read More>",
            "He can lump that there in such... <Read More>",
            "Time and missed a dare will do.",
            "Oh, you tell you will I'll make Tom was... <Read More>",
            "Let her go after all of the dirt, gripped together but.",
            "And some but because you're some, now, you do.",
            "But he had looked upon beautiful Bible.",
            "Have to Tom said to believe she.",
            "123456789A123456789B123456789C123456789D123456789E12345",
            "Inspiration well dressed on whitewashing with.",
            "Won't you about this moment, and went... <Read More>",
            "But it's all owing to be a dead... <Read More>",
            "They fashion.",
            "Tom this fence every time.",
            "123456789A123456789B123456789C123456789D... <Read More>",
            "123456789A 23456... <Read More>",
            "Well why constructing artificial... <Read More>",
            "When they would have been restless and... <Read More>",
            "And some sincere and.",
            "Presently oh, of.",
            "That's bigger Mont Blanc is what makes... <Read More>",
            "Say, Jim, I'll be familiar he climbed... <Read More>",
            "You ain't afraid the old heart most of gratitude.",
            "The retired artist sat and the waves of... <Read More>",
            "He he put the field with - and shabbier... <Read More>",
            "Were his premises - Tom's younger... <Read More>",
            "And White, mulatto, and sweated in the... <Read More>",
            "Well he turned his clothes were thrust... <Read More>",
            "Pump on all but he 'pears to do.",
            "He Bringing water from here on - and the writer of.",
            "Ting-a-ling-ling directions here,... <Read More>",
            "Go away from and incorruptible rocks... <Read More>",
            "A long, melodious whoop, at the town... <Read More>",
            "Troubled; next bench, and patting good... <Read More>",
            "Around among the awe which was too Tom Sawyer came and.",
            "The Old Scratch, but a deal of six... <Read More>",
            "The pulpit, with Can.",
            "Occasions, before was so it is a... <Read More>",
            "He had traded a bucket of it my duty by... <Read More>",
            "You sewed it, if he was propped on the... <Read More>",
            "Fog of your outside turn his finery and... <Read More>",
            "Blue tickets to seem a moment, and a... <Read More>",
            "Unconsciously to in the locust-trees... <Read More>",
            "He 'lowed to fall down the middle of... <Read More>",
            "Tom - why don't see it with hate but... <Read More>",
            "My boyhood - Ben hair, making a thing,... <Read More>",
            "The late that night, and a brother of a... <Read More>",
            "Thousand verses, even wore a dead... <Read More>",
            "So he altered his aunt; and it well I... <Read More>",
            "Fog of clean little while; they worried... <Read More>",
            "I dare will steal sheep Mr.",
            "And I've got to imagine himself in the brush.",
            "By the murmur of silent gratitude If he... <Read More>",
            "123456789A123456789B123456789C123456789... <Read More>",
            "Performing on all the spot every face... <Read More>",
            "Who you're some, now, no - wouldn't... <Read More>",
            "Six fire-crackers, a stiff... <Read More>",
            "Of St the corners of unwhitewashed.",
            "Makes me much more eying and noteworthy... <Read More>",
            "That Tom's whole little girl who you're... <Read More>",
            "Get away from his roundabout was simply... <Read More>",
            "Whole body is possible that Tom expressed it).",
            "Fashion fashion.",
            "Nothing had had looked upon all for the... <Read More>",
            "Would now let's see one needle.",
            "Now, you a I know just be prompted all eaten up.",
            "Is the air about to Tom said if they... <Read More>",
            "Fog of thirty-five, with a yellow... <Read More>",
            "From his pantaloons who drive... <Read More>",
            "They stood, each with black the Good Book says.",
            "Shake hands with fresh, and.",
            "123456789A123456789B123456789C123456789D... <Read More>",
            "Say she sews it long.",
            "Don't you look through, a Sunday-school... <Read More>",
            "Chow have liked to buy an instant both... <Read More>",
            "In good repair; and then somebody... <Read More>",
            "So he said he's full of the names of... <Read More>",
            "123456789A123456789B123456789C123456789D123456789E123 5",
            "Troubled; next chance to make it were his own Amy.",
            "You all his strain his work - added a... <Read More>",
            "Now let's see you can do we are... <Read More>",
            "Boys that produced by the library, by... <Read More>",
            "Tom was the headway ran like to, honest... <Read More>",
            "Didn't let him; Sid Only just acquired two minutes, or.",
            "But unquestionably his worldly matters,... <Read More>",
            "She tried to hear the great law of... <Read More>",
            "To seize well I got to be drawing nine... <Read More>",
            "123456789A123456789B123456789C123456789D... <Read More>",
            "Astronomer and his whitewashing, and a... <Read More>",
            "She say - and girls were full of... <Read More>",
            "Him a chance to buy an.",
            "SH'T off with next ten.",
            "123456789A123456789B123456789C123456789D... <Read More>",
            "Tom gwine I'll be a talent for the... <Read More>",
            "That he would turn his arms full of... <Read More>",
            "Comprehended that stage, now don't cry... <Read More>",
            "Come ahead on that they were half sorry... <Read More>",
            "Every face his name.",
            "I can't himself.",
            "You think of guile, and went on his... <Read More>"),
        this.output.toString());
  }
}
