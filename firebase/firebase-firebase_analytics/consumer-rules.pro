# Firebase
-keep class com.firebase.** { *; }
-keep class org.apache.** { *; }
-keepnames class javax.servlet.** { *; }
-keepnames class org.ietf.jgss.** { *; }
-dontwarn org.apache.**
-dontwarn org.w3c.dom.**
-dontwarn org.joda.time.**
-dontwarn org.shaded.apache.**
-dontwarn org.ietf.jgss.**

# Only necessary if you downloaded the SDK jar directly instead of from maven.
-keep class com.shaded.fasterxml.jackson.** { *; }

# Add this global rule
# 为返回并发布到 Firestore 数据库的应用程序模型类添加 proguard.cfg 规则。
#-keepattributes Signature
#-keepclassmembers class app.coinverse.analytics.models.** {*;}
#-keepclassmembers class app.coinverse.feed.models.** {*;}
#-keepclassmembers class app.coinverse.priceGraph.models.** {*;}
#-keepclassmembers class app.coinverse.user.models.** {*;}
#-keepclassmembers class app.coinverse.utils.** {*;}