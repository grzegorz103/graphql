INSERT INTO public.brands (id, name) VALUES (37, 'Porsche');
INSERT INTO public.brands (id, name) VALUES (43, 'BMW');
INSERT INTO public.brands (id, name) VALUES (44, 'Volkswagen');
INSERT INTO public.brands (id, name) VALUES (45, 'Suzuki');

INSERT INTO public.vehicle (dtype, id, model, year, brand_id, info) VALUES ('Car', 39, 'Panamera', 2016, 37, 'Porsche Panamera - samochód osobowy klasy wyższej produkowany pod niemiecką marką Porsche od 2009 roku. Od 2016 roku produkowana jest druga generacja pojazdu.

');
INSERT INTO public.vehicle (dtype, id, model, year, brand_id, info) VALUES ('Car', 38, 'Golf', 1998, 44, 'Volkswagen Golf − samochód osobowy klasy kompaktowej produkowany pod niemiecką marką Volkswagen od 1974 roku. Od 2019 roku produkowana jest ósma generacja modelu.

');
INSERT INTO public.vehicle (dtype, id, model, year, brand_id, info) VALUES ('Car', 36, 'E36', 1999, 43, 'BMW serii 3 – samochód osobowy klasy średniej produkowany pod niemiecką marką BMW od 1975 roku. Od 2018 roku produkowana jest siódma generacja modelu.

');
INSERT INTO public.vehicle (dtype, id, model, year, brand_id, info) VALUES ('Motorcycle', 40, 'Hayabusa', 2010, 45, 'Suzuki GSX 1300R Hayabusa – sportowo-turystyczny motocykl firmy Suzuki, wprowadzony na rynek w roku 1999. Nazwa „Hayabusa” pochodzi od japońskiego określenia najszybszego zwierzęcia świat');

INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (36, 'https://image.ceneostatic.pl/data/products/69805532/i-bmw-seria-3-e36-1995-km-coupe-czarny.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (36, 'https://d-gr.ppstatic.pl/kadry/k/r/gr-ogl/88/4b/224538_180626616_bmw-seria-3-iii-e36-coupe_xlarge.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (36, 'https://d-gr.ppstatic.pl/kadry/k/r/gr-ogl/88/4b/224538_180626660_bmw-seria-3-iii-e36-coupe_xlarge.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (38, 'https://d-mf.ppstatic.pl/art/au/bv/kgm8wiwo0s44ks4g0cogk/golf-1.1200.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (38, 'https://motopodprad.pl/wp-content/uploads/2017/12/7.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (38, 'https://i.wpimg.pl/730x0/m.autokult.pl/golf-6-59706b3a939920001-7755b12.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (39, 'https://image.ceneostatic.pl/data/products/88341530/i-porsche-panamera-gts-4-8-v8-najlepszy-silnik.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (39, 'https://img.tipcars.com/fotky_velke/38091412_4/1524487570/E/porsche-panamera-4s-4-8-v8-pasm-chronopaket.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (39, 'https://image.ceneostatic.pl/data/products/78684599/i-porsche-panamera-turbo-4-0-led.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (40, 'https://a.allegroimg.com/s512/03273f/6e22a9e441aab5ae27f822d2dd6e/Suzuki-Hayabusa-GSX-1300-R');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (40, 'https://motogen.pl/wp-content/uploads/2019/12/2019-suzuki-hayabusa-gsx-1300r-autoby-03.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (40, 'https://www.jednoslad.pl/wp-content/uploads/2016/006/4465-h1.jpg');
