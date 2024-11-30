package ru.itis;

import java.text.BreakIterator;
import java.util.Locale;

public class Main {
    public static int countSentences(String text) {
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(Locale.US);
        sentenceIterator.setText(text);
        int count = 0;
        while (sentenceIterator.next() != BreakIterator.DONE) {
            count++;
        }
        return count;
    }
    public static int countSentencesByPoint(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String t = "Introduction:\n" +
                "The issue of whether individual countries have the right to interfere in the affairs of another country is a contentious one. This topic is especially important in our time, due to the large number of armed conflicts and increasing economic and social tensions. Many are not against countries interfering in the affairs of others, many are against it. Let's look at the for's and againsts's.\n" +
                "For:\n" +
                "On one hand, interference can be justified under certain circumstances. For instance, when a humanitarian crisis or genocide threatens the lives of many, the international community may deem it necessary to intervene. Also, I consider interventions quite adequate if terrorism and terrorist organizations are flourishing on the territory of the country and could potentially harm many states and people. Revolutions and similar internal conflicts can lead to a series of conflicts in nearby (and not only) countries. If we remember history, and how after each French revolution there was a wave of revolutions across all European countries, then intervening in the conflict of a neighboring country is a good solution to the problem.Therefore, intervention is sometimes seen as a preventive measure to protect international interests.\n" +
                "Against:\n" +
                "On the other hand, interference is often perceived as a violation of a country’s sovereignty. This can lead to long-term consequences such as instability and conflict. State sovereignty is one of the main signs of a civilized peaceful society, which is repeatedly violated in our world. Also, such interventions to “eliminate terrorism” may not be genuine, and may be used to achieve the imperialist goals of the government.The problem is also in the methods of achieving goals. There are countries that absolutely shamelessly destroy everything they don’t like under the guise of assistance, use ammunition prohibited by conventions and other types of warfare that are not humane (of course, any war is not humane). Let's also consider the side of people. What if the revolution being carried out in the country is righteous and people simply cannot tolerate it anymore, but other countries intervene and crush the revolution, also for the sake of achieving their goals (perhaps they benefit from cooperation with the current government). In this case, such interference is a violation of human rights and freedoms and assistance to a potentially criminal government.\n" +
                "Conclusion:\n" +
                "Politics is a very complex and subtle topic, it is difficult to talk about it even with more than an average understanding. But one thing is clear - everyone interferes or does not interfere for their own reasons. And in 80% of cases these reasons are benefits. In any case, I would like to believe that the civilized world will learn to live and exist without conflicts and interference.";
        System.out.println(countSentences(t));
        System.out.println(countSentencesByPoint(t));
    }
}
