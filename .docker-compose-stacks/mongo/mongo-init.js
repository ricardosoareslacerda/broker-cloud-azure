db.createUser(
        {
            user: "root",
            pwd: "MongoDB2022!",
            roles: [
                {
                    role: "readWrite",
                    db: "dronedb"
                }
            ]
        }
);
db.createCollection('drones');