
-keepattributes Signature
-keepattributes *Annotation*

-dontwarn sun.misc.Unsafe

-keepclassmembers class com.jdots.ignou.conversation.data_model.** {*;}
-keepclassmembers class com.jdots.ignou.conversation_list.data_model.** {*;}
-keepclassmembers class com.jdots.ignou.global.data_model.** {*;}
-keepclassmembers class com.jdots.ignou.user.data_model.** {*;}

-keep public class com.jdots.ignou.login.**

-keep class com.android.vending.billing.**