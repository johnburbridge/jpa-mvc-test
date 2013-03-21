insert into PERSONS (ID, NAME) values 
    ('a85765e0-7e90-47b9-aea3-7da16117d274','person0'),
    ('9741afbb-a1be-47e0-9aa9-8a7f3702ffea','person1'),
    ('686ffd94-cbf7-4767-bf77-9d529b0087e7','person2'),
    ('a56fde5f-0033-4050-8964-2b8d7470ee28','person3'),
    ('952ed06c-0283-4866-b8e6-d16ca6f57312','person4'),
    ('78bb9ccc-ca3d-4e9d-90b6-931c854ef7ef','person5'),
    ('b3539be2-bf93-4353-8bf4-8ee57c1e9161','person6'),
    ('515728ad-669b-4f37-80b8-54264201786d','person7'),
    ('2404cbd8-6a18-4170-ad99-2f416f52b06b','person8'),
    ('54ec2667-ef87-4b35-8fc0-0c31e9b8a1d6','person9');

insert into GROUPS (ID, NAME) values 
    ('225c172b-950f-4c24-9ee7-4d3b4ea1cf55','odds'),
    ('1848d4b8-93b9-4970-be41-b366517af44b','evens'),
    ('f2c1fafa-af63-499b-8bdb-d7a0df26837f','other');

insert into GROUP_MEMBERS (GROUP_ID, PERSON_ID) values 
    ('225c172b-950f-4c24-9ee7-4d3b4ea1cf55', '9741afbb-a1be-47e0-9aa9-8a7f3702ffea'),
    ('225c172b-950f-4c24-9ee7-4d3b4ea1cf55', 'a56fde5f-0033-4050-8964-2b8d7470ee28'),
    ('1848d4b8-93b9-4970-be41-b366517af44b', 'a85765e0-7e90-47b9-aea3-7da16117d274'),
    ('1848d4b8-93b9-4970-be41-b366517af44b', '686ffd94-cbf7-4767-bf77-9d529b0087e7'),
    ('1848d4b8-93b9-4970-be41-b366517af44b', '952ed06c-0283-4866-b8e6-d16ca6f57312');


