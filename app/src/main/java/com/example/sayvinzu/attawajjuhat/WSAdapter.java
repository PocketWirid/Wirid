package com.example.sayvinzu.attawajjuhat;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by SAYVINZU on 22/07/2016.
 */

public class WSAdapter extends RecyclerView.Adapter<WSHolder>{

    private final Context context;
    private AssetManager as;
    LayoutInflater inflater;


    String ayat [] = {
    "أَعُوذُ بِاللهِ مِنَ الشَّيْطَانِ الرَّجِيْمِ",
    "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ ﴿١﴾ اَلْحَمْدُ لِلّٰهِ رَبِّ الْعٰلمِيْنَ ﴿۲﴾ الرَّحْمٰنِ الرَّحِيْمِ ﴿۳﴾ مٰلِكِ يَوْمِ الدِّيْنِ ﴿٤﴾ اِيَّاكَ نَعْبُدُ وَاِيَّاكَ نَسْتَعِيْمُ ﴿٥﴾ اِهْدِنَا الصِّرَاطَ الْمُسْتَقِيْمَ ﴿٦﴾ صِرَاطَ الَّذِيْنَ اَنْعَمْتَ عَلَيْهِمْ ۙ غَيْرِ الْمَغْضُوْبِ عَلَيْهِمْ وَلَا الضَّآلِّيْنَ ﴿٧﴾",
    "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ",
    "الٓمّٓ ﴿١﴾ ذٰلِكَ الْكِتٰبُ لَا رَيْبَ ۛ  فِيْهِ  ۛ  هُدًى لِّلْمُتَقِيْنَ ﴿۲﴾ الَّذِيْنَ يُؤْمِنُوْنَ بِالْغَيْبِ وَ يُقِيْمُوْنَ الصَّلٰوةَ وَمِمَّا رَزَقْنٰهُمْ يُنْفِقُوْنَ ﴿۳﴾ وَالَّذِيْنَ يُؤْمِنُوْنَ بِمَآ اُنْزِلَ اِلَيْكَ وَمَآ اُنْزِلَ مِنْ قَبْلِكَ ۚ وَبِالْاٰخِرَةِ هُمْ يُوْقِنُوْنَ ﴿٤﴾ اُولٰٓئِكَ عَلٰى هُدًى مِّنْ رَّبِّهِمْ ۙ وَاُولٰٓئِكَ هُمُ الْمُفْلِحُوْنَ ﴿٥﴾",
    "اللّٰهُ لَاۤ اِلٰهَ اِلَّا هُوَ الْحَـيُّ الْقَيُّوْمُ   ۚ  لَا تَأْخُذُهٗ سِنَةٌ وَّلَا نَوْمٌ  ؕ  لَهٗ مَا فِى السَّمٰوٰتِ وَمَا فِى الْاَرْضِ  ؕ  مَنْ ذَا الَّذِيْ يَشْفَعُ عِنْدَهٗۤ اِلَّا بِاِذْنِهٖ  ؕ  يَعْلَمُ مَا بَيْنَ اَيْدِيْهِمْ وَمَا خَلْفَهُمْ ۚ  وَلَا يُحِيْطُوْنَ بِشَيْءٍ مِّنْ عِلْمِهٖۤ اِلَّا بِمَا شَآءَ  ۚ  وَسِعَ كُرْسِيُّهُ السَّمٰوٰتِ وَالْاَرْضَ ۚ  وَلَا يَــئُوْدُهٗ حِفْظُهُمَا  ۚ  وَ هُوَ الْعَلِيُّ الْعَظِيْمُ ﴿۲٥٥﴾",
            "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ",
    "قُلْ هُوَ اللّٰهُ اَحَدٌ ﴿١﴾ اَللهُ الصَّمَدُ ﴿٢﴾ لَمْ يَلِدْ ۙ وَلَمْ يُوْلَدْ ﴿٣﴾ وَلَمْ يَكُنْ لَّهٗ كُفُوًا اَحَدٌ ﴿٤﴾ (٣x) ",
            "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ",
    "قُلْ اَعُوْذُ بِرَبِّ الْفَلَقَ ﴿١﴾ مِنْ شَرِّ مَا خَلَقَ ﴿٢﴾ وَمِنْ شَرِّ غَاسِقٍ اِذَا وَقَبَ ﴿٣﴾ وَمِنْ شَرِّ النَّفّٰثٰتِ فِي الْعُقَدِ ﴿٤﴾ وَمِنْ شَرِّ حَاسِدٍ اِذَا حَسَدَ ﴿٥﴾  (٣x)",
            "بِسْمِ اللهِ الرَّحْمٰنِ الرَّحِيْمِ",
    "قُلْ اَعُوْذُ بِرَّبِ النَّاسِ ﴿١﴾ مَلِكِ النَّاسِ ﴿٢﴾ اِلٰهِ النَّاسِ ﴿٣﴾ مِنْ شَرِّ الْوَسْوَاسِ الْخَنَّاسِ ﴿٤﴾ الَّذِيْ يُوَسْوِسُ فِيْ صُدُوْرِ النَّاسِ ﴿٥﴾ مِنَ الْجِنَّةِ وَالنَّاسِ ﴿٦﴾ (٣x) ",
    "اللَّهُمَّ بِكَ أَصْبَحْنَا ، وَبِكَ أَمْسَيْنَا ،وَبِكَ نَحْيَا، وَبِكَ نَمُوتُ، وَإِلَيْكَ الْمَصِيْرُ",
    "رَضِيْتُ بِاللهِ رَبًّا، وَبِاْلإِسْلاَمِ دِيْنًا، وَبِمُحَمَّدٍ نَبِيًّا (٣x)",
    "سُبْحَانَ اللهِ عَدَدَ خَلْقِهِ سُبْحَانَ اللهِ رِضَا نَفْسِهِ زِنَةَ عَرْشِهِ سُبْحَانَ اللهِ مِدَادَ كَلِمَاتِهِ (٣x)",
    "أَصْبَحْنَا عَلَى فِطْرَةِ الْإِسْلَامْ وَ عَلَى كَلِمَةِ الْإِخْلَاصٍ وَ عَلَى دِيْنِ نَبِيِّنَا مُحَمَّدٍ صَلَّى اللهُ عَلَيْهِ وَ سَلَّمَ وَعَلَى مِلَّةِ أَبِينَا إِبْرَاهِيْمَ حَنِيْفًا مُسْلِمًا وَمَا كَانَ مِنْ الْمُشْرِكِيْنَ",
    "اَللَّهُمَّ أَنْتَ رَبِّيْ لاَ إِلَـهَ إِلاَّ أَنْتَ، خَلَقْتَنِيْ وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ، أَعُوْذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ، أَبُوْءُ لَكَ بِنِعْمَتِكَ عَلَيَّ، وَأَبُوْءُ لَكَ بِذَنْبِيْ فَاغْفِرْ لِيْ فَإِنَّهُ لاَ يَغْفِرُ الذُّنُوْبَ إِلاَّ أَنْتَ",
    "أَصْبَحْنَا وَ أَصْبَحَ الْمُلْكُ للهِ، وَالْحَمْدُ للهِ، لَا إِلَهَ إِلاَّ اللهُ وَحْدَهُ لاَ شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِي هَذَا الْيَوْمِ وَخَيْرُ مَا بَعْدَهُ، وَأَعُوذُبِكَ مِنْ شَرِّ مَا فِي هَذَا الْيَوْمِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوذُبِكَ مِنَ الْكَسَلِ وَسُوءِ الْكِبَرِ، رَبِّ أَعُوذُبِكَ مِنْ عَذَابٍ فِي النَّارِ وَعَذَابٍ فِي الْقَبْرِ",
    "اَللَّهُمَّ فَاطِرَ السَّمَاوَاتِ وَاْلأَرْضِ، عَالِمَ الْغَيْبِ وَالشَّهَادَةِ، لاَ إِلَـهَ إِلاَّ أَنْتَ رَبَّ كُلِّ شَيْءٍ وَمَلِيْكَهُ، أَعُوْذُ بِكَ مِنْ شَرِّ نَفْسِيْ، وَمِنْ شَرِّ الشَّيْطَانِ وَشِرْكِهِ، وَأَنْ أَقْتَرِفَ عَلَى نَفْسِيْ سُوْءًا أَوْ أَجُرُّهُ إِلَى مُسْلِمٍ",
    "سُبْحَانَ اللهِ وَبِحَمْدِهِ (١٠٠x)",
    "اَللَّهُمَّ إِنِّيْ أَسْأَلُكَ الْعَفْوَ وَالْعَافِيَةَ فِي الدُّنْيَا وَاْلآخِرَةِ، اَللَّهُمَّ إِنِّيْ أَسْأَلُكَ الْعَفْوَ وَالْعَافِيَةَ فِي دِيْنِيْ وَدُنْيَايَ وَأَهْلِيْ وَمَالِيْ اللَّهُمَّ اسْتُرْ عَوْرَاتِى وَآمِنْ رَوْعَاتِى. اَللَّهُمَّ احْفَظْنِيْ مِنْ بَيْنِ يَدَيَّ، وَمِنْ خَلْفِيْ، وَعَنْ يَمِيْنِيْ وَعَنْ شِمَالِيْ، وَمِنْ فَوْقِيْ، وَأَعُوْذُ بِعَظَمَتِكَ أَنْ أُغْتَالَ مِنْ تَحْتِيْ",
    "بِسْمِ اللهِ الَّذِى لاَ يَضُرُّ مَعَ اسْمِهِ شَىْءٌ فِى الأَرْضِ وَلاَ فِى السَّمَاءِ وَهُوَ السَّمِيعُ الْعَلِيمُ (٣x)",
    "لاَ إِلَـهَ إِلاَّ اللهُ وَحْدَهُ لاَ شَرِيْكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيْرُ (١٠٠x)",
    "أَعُوْذُ بِكَلِمَاتِ اللهِ التَّامَّاتِ مِنْ شَرِّ مَا خَلَقَ (٣x)",
    "اَللَّهُمَّ عَافِنِيْ فِيْ بَدَنِيْ، اَللَّهُمَّ عَافِنِيْ فِيْ سَمْعِيْ، اَللَّهُمَّ عَافِنِيْ فِيْ بَصَرِيْ، لاَ إِلَـهَ إِلاَّ أَنْتَ. اَللَّهُمَّ إِنِّي أَعُوْذُ بِكَ مِنَ الْكُفْرِ وَالْفَقْرِ، وَأَعُوْذُ بِكَ مِنْ عَذَابِ الْقَبْرِ، لاَ إِلَـهَ إِلاَّ أَنْتَ (٣x)",
    "اَللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ وَعَلَى اَلِ مُحَمَّدٍ كَمَا صَلَّيْتَ عَلَى إِبْرَاهِيْمَ وَعَلَى اَلِ إِبْرَاهِيْمَ إِنَّكَ حَمِيْدٌ مَجِيْدٌ (١٠x)",
     "يَا حَيُّ يَا قَيُّوْمُ بِرَحْمَتِكَ أَسْتَغِيْثُ، وَأَصْلِحْ لِيْ شَأْنِيْ كُلَّهُ وَلاَ تَكِلْنِيْ إِلَى نَفْسِيْ طَرْفَةَ عَيْنٍ",
     "اَللَّهُمَّ إِنِّيْ أَسْأَلُكَ عِلْمًا نَافِعًا، وَعَمَلاً مُتَقَبَّلاً، وَرِزْقًا طَيِّبًا",
     "اَللَّهُمَّ مَا أَصْبَحَ بِيْ مِنْ نِعْمَةٍ فَمِنْكَ وَحْدَكَ لاَ شَرِيْكَ لَكَ، فَلَكَ الْحَمْدُ وَلَكَ الشُّكْرُ",
     "اَللَّهُمَّ لاَ سَهْلَ إِلاَّ مَا جَعَلْتَهُ سَهْلاً وَأَنْتَ تَجْعَلُ الحَزْنَ إِذَا شِئْتَ سَهْلاً",
     "اللَّهُمَّ أَلِّفْ بَيْنَ قُلُوْبِنَا وَأَصْلِحْ ذَاتَ بَيْنِنَا وَاهْدِنَا سُبُلَ السَّلاَمِ وَنَجِّنَا مِنْ الظُّلُمَاتِ إِلَى النُّورِ وَجَنِّبْنَا الْفَوَاحِشَ مَا ظَهَرَ مِنْهَا وَمَا بَطَنَ وَبَارِكْ لَنَا فِيِ أَسْمَاعِنَا وَأَبْصَارِنَا وَقُلُوبِنَا وَأَزْوَاجِنَا وَذُرِّيَّاتِنَا وَتُبْ عَلَيْنَا إِنَّكَ أَنْتَ التَّوَّابُ الرَّحِيْمُ وَاجَعَلْنَا شَاكِرِيْنَ لِنِعْمَتِك مُثْنِيْنَ بِهَا قَابِلِيْهَا وَأَتِمَّهَا عَلَيْنَا",
    "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ عِلْمٍ لَا يَنْفَعُ وَمِنْ قَلْبٍ لَا يَخْشَعُ وَمِنْ نَفْسٍ لَا تَشْبَعُ وَمِنْ دَعْوَةٍ لَا يُسْتَجَابُ لَهَا",
    "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ الْهَمِّ وَالحَزَنِ وَأَعُوذُ بِكَ مِنْ الْعَجْزِ وَالْكَسَلِ وَأَعُوذُ بِكَ مِنْ الجُبْنِ وَالْبُخْلِ وَأَعُوذُ بِكَ مِنْ غَلَبَةِ الدَّيْنِ وَقَهْرِ الرِّجَال",
     "أَعُوذُ بِعِزَّتِكَ الَّذِي لَا إِلَهَ إِلَّا أَنْتَ الَّذِي لَا يَمُوتُ وَالْجِنُّ وَالْإِنْسُ يَمُوتُونَ",
    "سُبْحَانَ الله وَبِحَمْدِهِ لَا قُوَّةَ إِلَّا بِاللهِ مَا شَاءَ اللهُ كَانَ وَمَا لَمْ يَشَأْ لَمْ يَكُنْ أَعْلَمُ أَنَّ اللهَ عَلَى كُلِّ شَىْءٍ قَدِيْرٌ وَأَنَّ اللهَ قَدْ أَحَاطَ بِكُلِّ شَىْءٍ عِلْمًا",
    "و صلى الله و سلم على محمد و على اله و صحبه أجمعين و الحمد لله رب العالمين"};

    String terjemah [] = {
            "\"Aku berlindung kepada Allah dari setan yang terkutuk (dijauhkan dari rahmat Allah)\"",
            "1. Dengan menyebut nama Allah yang Maha Pemurah lagi Maha Penyayang.\n " +
            "2. Segala puji bagi Allah, Tuhan semesta alam.\n" +
            "3. Maha Pemurah lagi Maha Penyayang.\n" +
            "4. Yang menguasai di hari Pembalasan.\n" +
            "5. Hanya kepada Engkaulah kami menyembah dan hanya kepada Engkaulah kami mohon pertolongan.\n" +
            "6. Tunjukilah kami jalan yang lurus.\n" +
            "7. (yaitu) jalan orang-orang yang telah Engkau beri nikmat kepadanya; bukan (jalan) mereka yang dimurkai, dan bukan (pula jalan) mereka yang sesat.",
            "Dengan menyebut nama Allah yang Maha Pemurah lagi Maha Penyayang.",
            "1. Alif Lam Mim.\n" +
            "2. Kitab (Al-Qur'an) ini tidak ada keraguan padanya; petunjuk bagi mereka yang bertakwa.\n" +
            "3. (yaitu) mereka yang beriman kepada yang gaib, melaksanakan sholat, dan menginfakkan sebagian rezeki yang Kami berikan kepada mereka.\n" +
            "4. dan mereka yang beriman kepada (Al-Qur'an) yang diturunkan kepadamu (Muhammad) dan (kitab-kitab) yang telah diturunkan sebelum engkau, dan mereka yakin akan adanya akhirat.\n" +
            "5. Merekalah yang mendapat petunjuk dari Tuhannya, dan mereka itulah orang-orang yang beruntung.",
            "Allah, tidak ada Tuhan (yang berhak disembah) melainkan Dia yang hidup kekal lagi terus menerus mengurus (makhluk-Nya); tidak mengantuk dan tidak tidur. Kepunyaan-Nya apa yang dilangit dan dibumi. " +
            "Tiada yang memberi syafa'at disisi Allah tanpa izin-Nya. Allah mengetahui apa-apa yang dihadapan mereka dan dibelakang mereka, dan mereka tidak mengetahui apa-apa dari ilmu Allah melainkan apa yang dikehendaki-Nya. " +
            "Kursi Allah melipiti langit dan bumi. Dan Allah tidak merasa berat memelihara keduanya.Dan Allah Maha Tinggi lagi Maha Besar (QS. Al-Baqarah : 255)",
            "Dengan menyebut nama Allah yang Maha Pemurah lagi Maha Penyayang.",
            "Katakanlah : \"Dia-lah Allah, yang Maha Esa. Allah adalah Tuhan yang bergantung kepada-Nya segala sesuatu. Dia tidak beranak dan tidak pula diperanakkan. Dan tidak ada seorangpun yang setara dengan Dia.\" ....3x (QS.Al-Ikhlas : 1-4)",
            "Dengan menyebut nama Allah yang Maha Pemurah lagi Maha Penyayang.",
            "Katakanlah : \"Aku berlindung kepada Tuhan yang menguasai subuh, dari kejahatan makhluk-Nya, dan dari kejahatan malam apabila telah gelap gulita, dan dari kejahatan wanita-wanita tukang sihir \" ....3x (QS. Al-Falaq : 1-5)",
            "Dengan menyebut nama Allah yang Maha Pemurah lagi Maha Penyayang.",
            "Katakanlah : \"Aku berlindung kepada Tuhan (yang memelihara dan menguasai) manusia. Raja manusia, sembahan manusia, dari kejahatan (bisikan) syaitan yang bisa bersembunyi, yang membisikkan (kejahatan) kedalam dada manusia, dari (golongan) jin dan manusia.\" ....3x (QS. An-Nas : 1-4)",
            "Ya Allah, dengan pertolongan-Mu kami berada di pagi hari, dan dengan pertolongan-Mu kami berada disore hari, dan dengan kehendak-Mu kami hidup serta mati, dan kepada-Mu kami dikumpulkan.",
            "\"Aku ",
            "acadads",
            "ascddadsadsa",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "ksakldlas",
            "adead",
            "fgrthythgvt",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "ksakldlas",
            "adead",
            "fgrthythgvt",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "ksakldlas",
            "adead",
            "fgrthythgvt",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "ksakldlas",
            "adead",
            "fgrthythgvt",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "ksakldlas",
            "adead",
            "fgrthythgvt",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "ksakldlas",
            "adead",
            "fgrthythgvt",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "ksakldlas",
            "adead",
            "fgrthythgvt",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "ksakldlas",
            "adead",
            "fgrthythgvt",
            "dhcndca",
            "acadads",
            "ascddadsadsa",
            "dhcndca",
            "acadads",
            "ascddadsadsa"};



    int nilai = 40;

    public WSAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        as = context.getAssets();
    }

    @Override
    public WSHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_item,parent,false);
        WSHolder wsHolder = new WSHolder(v);
        return wsHolder;
    }

    @Override
    public void onBindViewHolder(WSHolder holder, int position) {
        holder.a.setText(ayat[position]);
        holder.a.setOnClickListener(click_ayat);
        holder.a.setTextSize(nilai);
        holder.a.setTypeface(Typeface.createFromAsset(as,"fonts/tradbdo.ttf"));
        holder.a.setTag(holder);
        holder.b.setText(terjemah[position]);
        holder.b.setOnClickListener(click_terjemah);
        holder.b.setTag(holder);
    }

    View.OnClickListener click_ayat=new View.OnClickListener(){
        public void onClick(View v){
            WSHolder vholder = (WSHolder) v.getTag();
            int position = vholder.getAdapterPosition();
            Toast.makeText(context, "Ayat ini berada di posisi " + position, Toast.LENGTH_LONG).show();
        }
    };

    View.OnClickListener click_terjemah=new View.OnClickListener(){
        public void onClick(View v){
            WSHolder vholder = (WSHolder) v.getTag();
            int position = vholder.getAdapterPosition();
            Toast.makeText(context, "Terjemah ini berada di posisi " + position, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public int getItemCount() {
        return ayat.length;
    }


}
