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

INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (36, '2');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (36, '2');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (36, '2');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (38, 'https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (38, 'https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (38, 'https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (39, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSdxh-WnDLiwyUtQ93INH1LZ1otGzF19sfhKsBwbA_vfxpKc103');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (39, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSdxh-WnDLiwyUtQ93INH1LZ1otGzF19sfhKsBwbA_vfxpKc103');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (39, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSdxh-WnDLiwyUtQ93INH1LZ1otGzF19sfhKsBwbA_vfxpKc103');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (40, 'https://media.gettyimages.com/photos/paint-explosion-picture-id170955250?s=2048x2048');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (40, 'https://media.gettyimages.com/photos/paint-explosion-picture-id170955250?s=2048x2048');
INSERT INTO public.vehicle_images (vehicle_id, images) VALUES (40, 'https://media.gettyimages.com/photos/paint-explosion-picture-id170955250?s=2048x2048');
