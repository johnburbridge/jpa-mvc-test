insert into PERSONS (ID, NAME) values 
    ('a85765e0-7e90-47b9-aea3-7da16117d274','fake-person0'),
    ('9741afbb-a1be-47e0-9aa9-8a7f3702ffea','fake-person1'),
    ('686ffd94-cbf7-4767-bf77-9d529b0087e7','fake-person2'),
    ('a56fde5f-0033-4050-8964-2b8d7470ee28','fake-person3'),
    ('952ed06c-0283-4866-b8e6-d16ca6f57312','fake-person4'),
    ('78bb9ccc-ca3d-4e9d-90b6-931c854ef7ef','fake-person5'),
    ('b3539be2-bf93-4353-8bf4-8ee57c1e9161','fake-person6'),
    ('515728ad-669b-4f37-80b8-54264201786d','fake-person7'),
    ('2404cbd8-6a18-4170-ad99-2f416f52b06b','fake-person8'),
    ('54ec2667-ef87-4b35-8fc0-0c31e9b8a1d6','fake-person9');

insert into GROUPS (ID, NAME) values 
    ('225c172b-950f-4c24-9ee7-4d3b4ea1cf55','odds'),
    ('1848d4b8-93b9-4970-be41-b366517af44b','evens'),
    ('f2c1fafa-af63-499b-8bdb-d7a0df26837f','other');

insert into GROUP_MEMBERS (ID, GROUP_ID, PERSON_ID) values 
    ('b64399cd-a05c-4b88-99da-b18c9b16849c', '225c172b-950f-4c24-9ee7-4d3b4ea1cf55', '9741afbb-a1be-47e0-9aa9-8a7f3702ffea'),
    ('44566de3-b313-4e68-a868-437858d82aec', '225c172b-950f-4c24-9ee7-4d3b4ea1cf55', 'a56fde5f-0033-4050-8964-2b8d7470ee28'),
    ('c47946af-7482-4b4d-85b3-5f5424de3b13', '1848d4b8-93b9-4970-be41-b366517af44b', 'a85765e0-7e90-47b9-aea3-7da16117d274'),
    ('62f51b8d-4ca3-4dbc-86ca-e2f8ede55cc8', '1848d4b8-93b9-4970-be41-b366517af44b', '686ffd94-cbf7-4767-bf77-9d529b0087e7'),
    ('f311841c-4af6-4c4c-8e1d-8dd5ca84d7e7', '1848d4b8-93b9-4970-be41-b366517af44b', '952ed06c-0283-4866-b8e6-d16ca6f57312');


