# SoftwareEngineering_Lab5
## سوال اول
در ابتدا برنامه را اجرا میکنیم تا در برنامه‌ی yourkit آن را رصد بکنیم:
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/4f155c6d-625e-46c4-a954-638885562bc3)

همانطور که می‌بینید، اجرای برنامه به دلیل پرشدن heap به مشکل برخورد کرد. درادامه به کمک ابزار YourKit علت مشکل را بررسی میکنیم:
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/9c8a81cd-3d4d-46b3-b4cb-2aab68658cec)

![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/bcdaa722-b4ae-436f-94fb-3ed360da7fa8)

در تب‌های مختلف این نرم افزار میتوان میزان استفاده از منابع مختلف سیستم را مشاهده کرد و همانطور که در تصاویر بالا آورده شده، میتوان دید که مشکل اصلی برمیگردد به تابع temp. در این تابع، دو عدد حلقه‌ی نسبتا سنگین for تو در تو داریم که باعث میشود اجرای برنامه سریع و راحت نباشد. به عنوان راه حل، میتوان تعداد تکرار حلقه ها را کاهش داد مثلا حلقه اول یه جای 10000بار، 3000تایی باشد. اما به عنوان یک راه حل دوم، اگر نخواهیم/نتوانیم تعداد تکرار را تغییر دهیم، میتوان سایز ArrayList را که از ابتدا مشخص است برابر با مقدار ثابت 10000*20000 قرار داد و با اعمال این تغییر، برنامه دیگر به مشکل کمبود فضای heap نمیخورد و بدون مشکل اجرا میشود. دلیل این امر این است که در پیاده‌سازی پیش‌فرض ArrayList، وقتی سایز آن از قبل مشخص نباشد، هردفعه وقتی آرایه پر شد مجبور میشود که سایز آن را چند برابر کند و عملیات‌هایی در این بین انجام دهد. درحالیکه اگر از همان اول سایز آرایه مشخص و ثابت باشد، دیگر مشکلات قبلی ظاهر نمیشود.
در ادامه پیاده‌سازی بهبودیافته‌ی تابع temp و نتیجه‌ی اجرای آن در YourKit را مشاهده میکنید:
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/30799b22-fb44-45dc-beb6-3624eef34ae0)

![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/61430956-4fa0-4eca-b966-18c8252e743b)

<br><br><br>

## سوال دوم
برای این قسمت، برنامه‌ای نوشتیم که دو کار را انجام میدهد. محاسبه‌ی فاکتوریل عدد ورودی n و محاسبه‌ی عدد فیبوناچی m ام. محاسبه‌ی فاکتوریل زمان خاصی نمیبرد ولی محاسبه‌ی فیبوناچی به دلیل الگوریتم غیربهینه‌ای که استفاده شده است، منابع بیشتری استفاده میکند. درادامه تصاویری از کد مربوط به این قسمت و نمونه اجرای آن به همراه گزارش profile کردن برنامه را مشاهده میکنید:
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/d2107b3d-8161-4f07-9518-d414ddc2530b)
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/319328be-510b-4204-84d5-eca2f36d579b)
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/2be1e135-9c76-48ed-adbd-35d3ad58c07e)
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/d76e0a19-5703-4a38-9197-3a402d3e98a8)
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/a6c42b05-e2c0-46ea-99e4-cf3199dd6634)

همانطور که مشاهده میکنید اجرای برنامه مدت نسبتا زیادی طول کشیده است یعنی 1406 میلی ثانیه که دلیل اصلی آن هم تابع ()fib است که مربوط به محاسبه عدد فیبوناچی است. برای بهبود آن میتوان از caching استفاده کرد به این صورت که هردفعه وقتی یک عدد از دنباله فیبوناچی را حساب کردیم، آن را یک HashMap ذخیره کنیم تا بعدا دوباره مجبور نشویم آن را محاسبه کنیم. درادامه کد اصلاح شده و گزارش اجرای برنامه را مشاهده میکنید:
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/9469d559-8dac-4891-aa17-c1b9ca8a0d5d)
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/130cd2b9-8fce-4103-ab83-3b6f0cb5738a)
![image](https://github.com/matinmoradi80/SoftwareEngineering_Lab5/assets/62210384/cb8c73b0-7311-4875-a234-9096566f7517)

طبق آنچه YourKit گزارش کرده است، برنامه در مدت زمان 31 میلی ثانیه با منابع بسیار بسیار کمتر اجرا شده است.


