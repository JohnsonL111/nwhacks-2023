INSERT INTO public.location (id, name) VALUES (1, 'UBC') ON CONFLICT DO NOTHING;
INSERT INTO public.location (id, name) VALUES (2, 'SFU') ON CONFLICT DO NOTHING;
INSERT INTO public.location (id, name) VALUES (3, 'BCIT') ON CONFLICT DO NOTHING;
INSERT INTO public.location (id, name) VALUES (4, 'Stanley Park') ON CONFLICT DO NOTHING;
INSERT INTO public.location (id, name) VALUES (5, 'Chinatown') ON CONFLICT DO NOTHING;
INSERT INTO public.location (id, name) VALUES (6, 'Dairy Queen') ON CONFLICT DO NOTHING;
INSERT INTO public.location (id, name) VALUES (7, 'Burrard Street') ON CONFLICT DO NOTHING;

INSERT INTO public.person (id, phone_number, username, current_location_id) VALUES (1, '604 442 3403', 'Josh', null) ON CONFLICT DO NOTHING;
INSERT INTO public.person (id, phone_number, username, current_location_id) VALUES (2, '778 903 7860', 'Maliha', null) ON CONFLICT DO NOTHING;
INSERT INTO public.person (id, phone_number, username, current_location_id) VALUES (3, '604-379-2278', 'Johnson', null) ON CONFLICT DO NOTHING;
INSERT INTO public.person (id, phone_number, username, current_location_id) VALUES (4, '778 227 7145', 'Justin', null) ON CONFLICT DO NOTHING;
