package jlerisiri;

/**
 * This grammar is generated using the Grammar.export_java() method and
 * should be used with the jleri module.
 *
 * Source class: SiriGrammar
 * Created at: 2018-07-04 11:04:44
 */

import jleri.Grammar;
import jleri.Element;
import jleri.Token;
import jleri.Prio;
import jleri.Keyword;
import jleri.Sequence;
import jleri.List;
import jleri.This;
import jleri.Repeat;
import jleri.Choice;
import jleri.Regex;
import jleri.Ref;
import jleri.Tokens;
import jleri.Optional;

public class SiriGrammar extends Grammar {
    enum Ids {
        ACCESS_EXPR,
        ACCESS_KEYWORDS,
        AFTER_EXPR,
        AGGREGATE_FUNCTIONS,
        ALTER_DATABASE,
        ALTER_GROUP,
        ALTER_SERVER,
        ALTER_SERVERS,
        ALTER_STMT,
        ALTER_USER,
        BEFORE_EXPR,
        BETWEEN_EXPR,
        BOOL_OPERATOR,
        CALC_STMT,
        COUNT_GROUPS,
        COUNT_POOLS,
        COUNT_SERIES,
        COUNT_SERIES_LENGTH,
        COUNT_SERVERS,
        COUNT_SERVERS_RECEIVED,
        COUNT_SERVERS_SELECTED,
        COUNT_SHARDS,
        COUNT_SHARDS_SIZE,
        COUNT_STMT,
        COUNT_USERS,
        CREATE_GROUP,
        CREATE_STMT,
        CREATE_USER,
        C_DIFFERENCE,
        DROP_GROUP,
        DROP_SERIES,
        DROP_SERVER,
        DROP_SHARDS,
        DROP_STMT,
        DROP_USER,
        F_ALL,
        F_COUNT,
        F_DERIVATIVE,
        F_DIFFERENCE,
        F_FILTER,
        F_FIRST,
        F_LAST,
        F_LIMIT,
        F_MAX,
        F_MEAN,
        F_MEDIAN,
        F_MEDIAN_HIGH,
        F_MEDIAN_LOW,
        F_MIN,
        F_POINTS,
        F_PVARIANCE,
        F_STDDEV,
        F_SUM,
        F_VARIANCE,
        GRANT_STMT,
        GRANT_USER,
        GROUP_COLUMNS,
        GROUP_MATCH,
        GROUP_NAME,
        HELP_ACCESS,
        HELP_ALTER,
        HELP_ALTER_DATABASE,
        HELP_ALTER_GROUP,
        HELP_ALTER_SERVER,
        HELP_ALTER_SERVERS,
        HELP_ALTER_USER,
        HELP_COUNT,
        HELP_COUNT_GROUPS,
        HELP_COUNT_POOLS,
        HELP_COUNT_SERIES,
        HELP_COUNT_SERVERS,
        HELP_COUNT_SHARDS,
        HELP_COUNT_USERS,
        HELP_CREATE,
        HELP_CREATE_GROUP,
        HELP_CREATE_USER,
        HELP_DROP,
        HELP_DROP_GROUP,
        HELP_DROP_SERIES,
        HELP_DROP_SERVER,
        HELP_DROP_SHARDS,
        HELP_DROP_USER,
        HELP_FUNCTIONS,
        HELP_GRANT,
        HELP_LIST,
        HELP_LIST_GROUPS,
        HELP_LIST_POOLS,
        HELP_LIST_SERIES,
        HELP_LIST_SERVERS,
        HELP_LIST_SHARDS,
        HELP_LIST_USERS,
        HELP_NOACCESS,
        HELP_REVOKE,
        HELP_SELECT,
        HELP_SHOW,
        HELP_STMT,
        HELP_TIMEIT,
        HELP_TIMEZONES,
        INT_EXPR,
        INT_OPERATOR,
        K_ACCESS,
        K_ACTIVE_HANDLES,
        K_ACTIVE_TASKS,
        K_ADDRESS,
        K_AFTER,
        K_ALL,
        K_ALTER,
        K_AND,
        K_AS,
        K_BACKUP_MODE,
        K_BEFORE,
        K_BETWEEN,
        K_BUFFER_PATH,
        K_BUFFER_SIZE,
        K_COUNT,
        K_CREATE,
        K_CRITICAL,
        K_DATABASE,
        K_DBNAME,
        K_DBPATH,
        K_DEBUG,
        K_DERIVATIVE,
        K_DIFFERENCE,
        K_DROP,
        K_DROP_THRESHOLD,
        K_DURATION_LOG,
        K_DURATION_NUM,
        K_END,
        K_ERROR,
        K_EXPRESSION,
        K_FALSE,
        K_FIFO_FILES,
        K_FILTER,
        K_FIRST,
        K_FLOAT,
        K_FOR,
        K_FROM,
        K_FULL,
        K_GRANT,
        K_GROUP,
        K_GROUPS,
        K_HELP,
        K_IDLE_PERCENTAGE,
        K_IDLE_TIME,
        K_IGNORE_THRESHOLD,
        K_INF,
        K_INFO,
        K_INSERT,
        K_INTEGER,
        K_INTERSECTION,
        K_IP_SUPPORT,
        K_LAST,
        K_LENGTH,
        K_LIBUV,
        K_LIMIT,
        K_LIST,
        K_LIST_LIMIT,
        K_LOG,
        K_LOG_LEVEL,
        K_MAX,
        K_MAX_OPEN_FILES,
        K_MEAN,
        K_MEDIAN,
        K_MEDIAN_HIGH,
        K_MEDIAN_LOW,
        K_MEM_USAGE,
        K_MERGE,
        K_MIN,
        K_MODIFY,
        K_NAME,
        K_NAN,
        K_NINF,
        K_NOW,
        K_NUMBER,
        K_ONLINE,
        K_OPEN_FILES,
        K_OR,
        K_PASSWORD,
        K_POINTS,
        K_POOL,
        K_POOLS,
        K_PORT,
        K_PREFIX,
        K_PVARIANCE,
        K_READ,
        K_RECEIVED_POINTS,
        K_REINDEX_PROGRESS,
        K_REVOKE,
        K_SELECT,
        K_SELECTED_POINTS,
        K_SELECT_POINTS_LIMIT,
        K_SERIES,
        K_SERVER,
        K_SERVERS,
        K_SET,
        K_SHARDS,
        K_SHOW,
        K_SID,
        K_SIZE,
        K_START,
        K_STARTUP_TIME,
        K_STATUS,
        K_STDDEV,
        K_STRING,
        K_SUFFIX,
        K_SUM,
        K_SYMMETRIC_DIFFERENCE,
        K_SYNC_PROGRESS,
        K_TIMEIT,
        K_TIMEZONE,
        K_TIME_PRECISION,
        K_TO,
        K_TRUE,
        K_TYPE,
        K_UNION,
        K_UPTIME,
        K_USER,
        K_USERS,
        K_USING,
        K_UUID,
        K_VARIANCE,
        K_VERSION,
        K_WARNING,
        K_WHERE,
        K_WHO_AM_I,
        K_WRITE,
        LIMIT_EXPR,
        LIST_GROUPS,
        LIST_POOLS,
        LIST_SERIES,
        LIST_SERVERS,
        LIST_SHARDS,
        LIST_STMT,
        LIST_USERS,
        LOG_KEYWORDS,
        MERGE_AS,
        POOL_COLUMNS,
        POOL_PROPS,
        PREFIX_EXPR,
        REVOKE_STMT,
        REVOKE_USER,
        R_COMMENT,
        R_DOUBLEQ_STR,
        R_FLOAT,
        R_GRAVE_STR,
        R_INTEGER,
        R_REGEX,
        R_SINGLEQ_STR,
        R_TIME_STR,
        R_UINTEGER,
        R_UUID_STR,
        SELECT_AGGREGATE,
        SELECT_AGGREGATES,
        SELECT_STMT,
        SERIES_ALL,
        SERIES_COLUMNS,
        SERIES_MATCH,
        SERIES_NAME,
        SERIES_RE,
        SERIES_SEP,
        SERVER_COLUMNS,
        SET_ADDRESS,
        SET_BACKUP_MODE,
        SET_DROP_THRESHOLD,
        SET_EXPRESSION,
        SET_IGNORE_THRESHOLD,
        SET_LIST_LIMIT,
        SET_LOG_LEVEL,
        SET_NAME,
        SET_PASSWORD,
        SET_PORT,
        SET_SELECT_POINTS_LIMIT,
        SET_TIMEZONE,
        SHARD_COLUMNS,
        SHOW_STMT,
        START,
        STRING,
        STR_OPERATOR,
        SUFFIX_EXPR,
        TIMEIT_STMT,
        TIME_EXPR,
        USER_COLUMNS,
        UUID,
        WHERE_GROUP,
        WHERE_POOL,
        WHERE_SERIES,
        WHERE_SERVER,
        WHERE_SHARD,
        WHERE_USER,
        _BOOLEAN
    }

    private static final Element R_FLOAT = new Regex(Ids.R_FLOAT, "^[-+]?[0-9]*\\.?[0-9]+");
    private static final Element R_INTEGER = new Regex(Ids.R_INTEGER, "^[-+]?[0-9]+");
    private static final Element R_UINTEGER = new Regex(Ids.R_UINTEGER, "^[0-9]+");
    private static final Element R_TIME_STR = new Regex(Ids.R_TIME_STR, "^[0-9]+[smhdw]");
    private static final Element R_SINGLEQ_STR = new Regex(Ids.R_SINGLEQ_STR, "^(?:\'(?:[^\']*)\')+");
    private static final Element R_DOUBLEQ_STR = new Regex(Ids.R_DOUBLEQ_STR, "^(?:\"(?:[^\"]*)\")+");
    private static final Element R_GRAVE_STR = new Regex(Ids.R_GRAVE_STR, "^(?:`(?:[^`]*)`)+");
    private static final Element R_UUID_STR = new Regex(Ids.R_UUID_STR, "^[0-9a-f]{8}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{12}");
    private static final Element R_REGEX = new Regex(Ids.R_REGEX, "^(/[^/\\\\]*(?:\\\\.[^/\\\\]*)*/i?)");
    private static final Element R_COMMENT = new Regex(Ids.R_COMMENT, "^#.*");
    private static final Element K_ACCESS = new Keyword(Ids.K_ACCESS, "access", false);
    private static final Element K_ACTIVE_HANDLES = new Keyword(Ids.K_ACTIVE_HANDLES, "active_handles", false);
    private static final Element K_ACTIVE_TASKS = new Keyword(Ids.K_ACTIVE_TASKS, "active_tasks", false);
    private static final Element K_ADDRESS = new Keyword(Ids.K_ADDRESS, "address", false);
    private static final Element K_AFTER = new Keyword(Ids.K_AFTER, "after", false);
    private static final Element K_ALL = new Keyword(Ids.K_ALL, "all", false);
    private static final Element K_ALTER = new Keyword(Ids.K_ALTER, "alter", false);
    private static final Element K_AND = new Keyword(Ids.K_AND, "and", false);
    private static final Element K_AS = new Keyword(Ids.K_AS, "as", false);
    private static final Element K_BACKUP_MODE = new Keyword(Ids.K_BACKUP_MODE, "backup_mode", false);
    private static final Element K_BEFORE = new Keyword(Ids.K_BEFORE, "before", false);
    private static final Element K_BUFFER_SIZE = new Keyword(Ids.K_BUFFER_SIZE, "buffer_size", false);
    private static final Element K_BUFFER_PATH = new Keyword(Ids.K_BUFFER_PATH, "buffer_path", false);
    private static final Element K_BETWEEN = new Keyword(Ids.K_BETWEEN, "between", false);
    private static final Element K_COUNT = new Keyword(Ids.K_COUNT, "count", false);
    private static final Element K_CREATE = new Keyword(Ids.K_CREATE, "create", false);
    private static final Element K_CRITICAL = new Keyword(Ids.K_CRITICAL, "critical", false);
    private static final Element K_DATABASE = new Keyword(Ids.K_DATABASE, "database", false);
    private static final Element K_DBNAME = new Keyword(Ids.K_DBNAME, "dbname", false);
    private static final Element K_DBPATH = new Keyword(Ids.K_DBPATH, "dbpath", false);
    private static final Element K_DEBUG = new Keyword(Ids.K_DEBUG, "debug", false);
    private static final Element K_DERIVATIVE = new Keyword(Ids.K_DERIVATIVE, "derivative", false);
    private static final Element K_DIFFERENCE = new Keyword(Ids.K_DIFFERENCE, "difference", false);
    private static final Element K_DROP = new Keyword(Ids.K_DROP, "drop", false);
    private static final Element K_DROP_THRESHOLD = new Keyword(Ids.K_DROP_THRESHOLD, "drop_threshold", false);
    private static final Element K_DURATION_LOG = new Keyword(Ids.K_DURATION_LOG, "duration_log", false);
    private static final Element K_DURATION_NUM = new Keyword(Ids.K_DURATION_NUM, "duration_num", false);
    private static final Element K_END = new Keyword(Ids.K_END, "end", false);
    private static final Element K_ERROR = new Keyword(Ids.K_ERROR, "error", false);
    private static final Element K_EXPRESSION = new Keyword(Ids.K_EXPRESSION, "expression", false);
    private static final Element K_FALSE = new Keyword(Ids.K_FALSE, "false", false);
    private static final Element K_FIFO_FILES = new Keyword(Ids.K_FIFO_FILES, "fifo_files", false);
    private static final Element K_FILTER = new Keyword(Ids.K_FILTER, "filter", false);
    private static final Element K_FIRST = new Keyword(Ids.K_FIRST, "first", false);
    private static final Element K_FLOAT = new Keyword(Ids.K_FLOAT, "float", false);
    private static final Element K_FOR = new Keyword(Ids.K_FOR, "for", false);
    private static final Element K_FROM = new Keyword(Ids.K_FROM, "from", false);
    private static final Element K_FULL = new Keyword(Ids.K_FULL, "full", false);
    private static final Element K_GRANT = new Keyword(Ids.K_GRANT, "grant", false);
    private static final Element K_GROUP = new Keyword(Ids.K_GROUP, "group", false);
    private static final Element K_GROUPS = new Keyword(Ids.K_GROUPS, "groups", false);
    private static final Element K_HELP = new Choice(
        Ids.K_HELP,
        true,
        new Keyword("help", false),
        new Token("?")
    );
    private static final Element K_IDLE_PERCENTAGE = new Keyword(Ids.K_IDLE_PERCENTAGE, "idle_percentage", false);
    private static final Element K_IDLE_TIME = new Keyword(Ids.K_IDLE_TIME, "idle_time", false);
    private static final Element K_INF = new Keyword(Ids.K_INF, "inf", false);
    private static final Element K_INFO = new Keyword(Ids.K_INFO, "info", false);
    private static final Element K_IGNORE_THRESHOLD = new Keyword(Ids.K_IGNORE_THRESHOLD, "ignore_threshold", false);
    private static final Element K_INSERT = new Keyword(Ids.K_INSERT, "insert", false);
    private static final Element K_INTEGER = new Keyword(Ids.K_INTEGER, "integer", false);
    private static final Element K_INTERSECTION = new Choice(
        Ids.K_INTERSECTION,
        false,
        new Token("&"),
        new Keyword("intersection", false)
    );
    private static final Element K_IP_SUPPORT = new Keyword(Ids.K_IP_SUPPORT, "ip_support", false);
    private static final Element K_LAST = new Keyword(Ids.K_LAST, "last", false);
    private static final Element K_LENGTH = new Keyword(Ids.K_LENGTH, "length", false);
    private static final Element K_LIBUV = new Keyword(Ids.K_LIBUV, "libuv", false);
    private static final Element K_LIMIT = new Keyword(Ids.K_LIMIT, "limit", false);
    private static final Element K_LIST = new Keyword(Ids.K_LIST, "list", false);
    private static final Element K_LIST_LIMIT = new Keyword(Ids.K_LIST_LIMIT, "list_limit", false);
    private static final Element K_LOG = new Keyword(Ids.K_LOG, "log", false);
    private static final Element K_LOG_LEVEL = new Keyword(Ids.K_LOG_LEVEL, "log_level", false);
    private static final Element K_MAX = new Keyword(Ids.K_MAX, "max", false);
    private static final Element K_MAX_OPEN_FILES = new Keyword(Ids.K_MAX_OPEN_FILES, "max_open_files", false);
    private static final Element K_MEAN = new Keyword(Ids.K_MEAN, "mean", false);
    private static final Element K_MEDIAN = new Keyword(Ids.K_MEDIAN, "median", false);
    private static final Element K_MEDIAN_LOW = new Keyword(Ids.K_MEDIAN_LOW, "median_low", false);
    private static final Element K_MEDIAN_HIGH = new Keyword(Ids.K_MEDIAN_HIGH, "median_high", false);
    private static final Element K_MEM_USAGE = new Keyword(Ids.K_MEM_USAGE, "mem_usage", false);
    private static final Element K_MERGE = new Keyword(Ids.K_MERGE, "merge", false);
    private static final Element K_MIN = new Keyword(Ids.K_MIN, "min", false);
    private static final Element K_MODIFY = new Keyword(Ids.K_MODIFY, "modify", false);
    private static final Element K_NAN = new Keyword(Ids.K_NAN, "nan", false);
    private static final Element K_NAME = new Keyword(Ids.K_NAME, "name", false);
    private static final Element K_NINF = new Sequence(
        Ids.K_NINF,
        new Token("-"),
        K_INF
    );
    private static final Element K_NOW = new Keyword(Ids.K_NOW, "now", false);
    private static final Element K_NUMBER = new Keyword(Ids.K_NUMBER, "number", false);
    private static final Element K_ONLINE = new Keyword(Ids.K_ONLINE, "online", false);
    private static final Element K_OPEN_FILES = new Keyword(Ids.K_OPEN_FILES, "open_files", false);
    private static final Element K_OR = new Keyword(Ids.K_OR, "or", false);
    private static final Element K_PASSWORD = new Keyword(Ids.K_PASSWORD, "password", false);
    private static final Element K_POINTS = new Keyword(Ids.K_POINTS, "points", false);
    private static final Element K_POOL = new Keyword(Ids.K_POOL, "pool", false);
    private static final Element K_POOLS = new Keyword(Ids.K_POOLS, "pools", false);
    private static final Element K_PORT = new Keyword(Ids.K_PORT, "port", false);
    private static final Element K_PREFIX = new Keyword(Ids.K_PREFIX, "prefix", false);
    private static final Element K_PVARIANCE = new Keyword(Ids.K_PVARIANCE, "pvariance", false);
    private static final Element K_READ = new Keyword(Ids.K_READ, "read", false);
    private static final Element K_RECEIVED_POINTS = new Keyword(Ids.K_RECEIVED_POINTS, "received_points", false);
    private static final Element K_REINDEX_PROGRESS = new Keyword(Ids.K_REINDEX_PROGRESS, "reindex_progress", false);
    private static final Element K_REVOKE = new Keyword(Ids.K_REVOKE, "revoke", false);
    private static final Element K_SELECT = new Keyword(Ids.K_SELECT, "select", false);
    private static final Element K_SELECT_POINTS_LIMIT = new Keyword(Ids.K_SELECT_POINTS_LIMIT, "select_points_limit", false);
    private static final Element K_SELECTED_POINTS = new Keyword(Ids.K_SELECTED_POINTS, "selected_points", false);
    private static final Element K_SERIES = new Keyword(Ids.K_SERIES, "series", false);
    private static final Element K_SERVER = new Keyword(Ids.K_SERVER, "server", false);
    private static final Element K_SERVERS = new Keyword(Ids.K_SERVERS, "servers", false);
    private static final Element K_SET = new Keyword(Ids.K_SET, "set", false);
    private static final Element K_SID = new Keyword(Ids.K_SID, "sid", false);
    private static final Element K_SHARDS = new Keyword(Ids.K_SHARDS, "shards", false);
    private static final Element K_SHOW = new Keyword(Ids.K_SHOW, "show", false);
    private static final Element K_SIZE = new Keyword(Ids.K_SIZE, "size", false);
    private static final Element K_START = new Keyword(Ids.K_START, "start", false);
    private static final Element K_STARTUP_TIME = new Keyword(Ids.K_STARTUP_TIME, "startup_time", false);
    private static final Element K_STATUS = new Keyword(Ids.K_STATUS, "status", false);
    private static final Element K_STDDEV = new Keyword(Ids.K_STDDEV, "stddev", false);
    private static final Element K_STRING = new Keyword(Ids.K_STRING, "string", false);
    private static final Element K_SUFFIX = new Keyword(Ids.K_SUFFIX, "suffix", false);
    private static final Element K_SUM = new Keyword(Ids.K_SUM, "sum", false);
    private static final Element K_SYMMETRIC_DIFFERENCE = new Choice(
        Ids.K_SYMMETRIC_DIFFERENCE,
        false,
        new Token("^"),
        new Keyword("symmetric_difference", false)
    );
    private static final Element K_SYNC_PROGRESS = new Keyword(Ids.K_SYNC_PROGRESS, "sync_progress", false);
    private static final Element K_TIMEIT = new Keyword(Ids.K_TIMEIT, "timeit", false);
    private static final Element K_TIMEZONE = new Keyword(Ids.K_TIMEZONE, "timezone", false);
    private static final Element K_TIME_PRECISION = new Keyword(Ids.K_TIME_PRECISION, "time_precision", false);
    private static final Element K_TO = new Keyword(Ids.K_TO, "to", false);
    private static final Element K_TRUE = new Keyword(Ids.K_TRUE, "true", false);
    private static final Element K_TYPE = new Keyword(Ids.K_TYPE, "type", false);
    private static final Element K_UNION = new Choice(
        Ids.K_UNION,
        false,
        new Tokens(", |"),
        new Keyword("union", false)
    );
    private static final Element K_UPTIME = new Keyword(Ids.K_UPTIME, "uptime", false);
    private static final Element K_USER = new Keyword(Ids.K_USER, "user", false);
    private static final Element K_USERS = new Keyword(Ids.K_USERS, "users", false);
    private static final Element K_USING = new Keyword(Ids.K_USING, "using", false);
    private static final Element K_UUID = new Keyword(Ids.K_UUID, "uuid", false);
    private static final Element K_VARIANCE = new Keyword(Ids.K_VARIANCE, "variance", false);
    private static final Element K_VERSION = new Keyword(Ids.K_VERSION, "version", false);
    private static final Element K_WARNING = new Keyword(Ids.K_WARNING, "warning", false);
    private static final Element K_WHERE = new Keyword(Ids.K_WHERE, "where", false);
    private static final Element K_WHO_AM_I = new Keyword(Ids.K_WHO_AM_I, "who_am_i", false);
    private static final Element K_WRITE = new Keyword(Ids.K_WRITE, "write", false);
    private static final Element C_DIFFERENCE = new Choice(
        Ids.C_DIFFERENCE,
        false,
        new Token("-"),
        K_DIFFERENCE
    );
    private static final Element ACCESS_KEYWORDS = new Choice(
        Ids.ACCESS_KEYWORDS,
        false,
        K_READ,
        K_WRITE,
        K_MODIFY,
        K_FULL,
        K_SELECT,
        K_SHOW,
        K_LIST,
        K_COUNT,
        K_CREATE,
        K_INSERT,
        K_DROP,
        K_GRANT,
        K_REVOKE,
        K_ALTER
    );
    private static final Element _BOOLEAN = new Choice(
        Ids._BOOLEAN,
        false,
        K_TRUE,
        K_FALSE
    );
    private static final Element LOG_KEYWORDS = new Choice(
        Ids.LOG_KEYWORDS,
        false,
        K_DEBUG,
        K_INFO,
        K_WARNING,
        K_ERROR,
        K_CRITICAL
    );
    private static final Element INT_EXPR = new Prio(
        Ids.INT_EXPR,
        R_INTEGER,
        new Sequence(
            new Token("("),
            This.THIS,
            new Token(")")
        ),
        new Sequence(
            This.THIS,
            new Tokens("+ - * % /"),
            This.THIS
        )
    );
    private static final Element STRING = new Choice(
        Ids.STRING,
        false,
        R_SINGLEQ_STR,
        R_DOUBLEQ_STR
    );
    private static final Element TIME_EXPR = new Prio(
        Ids.TIME_EXPR,
        R_TIME_STR,
        K_NOW,
        STRING,
        R_INTEGER,
        new Sequence(
            new Token("("),
            This.THIS,
            new Token(")")
        ),
        new Sequence(
            This.THIS,
            new Tokens("+ - * % /"),
            This.THIS
        )
    );
    private static final Element SERIES_COLUMNS = new List(Ids.SERIES_COLUMNS, new Choice(
        false,
        K_NAME,
        K_TYPE,
        K_LENGTH,
        K_START,
        K_END,
        K_POOL
    ), new Token(","), 1, null, false);
    private static final Element SHARD_COLUMNS = new List(Ids.SHARD_COLUMNS, new Choice(
        false,
        K_SID,
        K_POOL,
        K_SERVER,
        K_SIZE,
        K_START,
        K_END,
        K_TYPE,
        K_STATUS
    ), new Token(","), 1, null, false);
    private static final Element SERVER_COLUMNS = new List(Ids.SERVER_COLUMNS, new Choice(
        false,
        K_ADDRESS,
        K_BUFFER_PATH,
        K_BUFFER_SIZE,
        K_DBPATH,
        K_IP_SUPPORT,
        K_LIBUV,
        K_NAME,
        K_PORT,
        K_UUID,
        K_POOL,
        K_VERSION,
        K_ONLINE,
        K_STARTUP_TIME,
        K_STATUS,
        K_ACTIVE_HANDLES,
        K_ACTIVE_TASKS,
        K_FIFO_FILES,
        K_IDLE_PERCENTAGE,
        K_IDLE_TIME,
        K_LOG_LEVEL,
        K_MAX_OPEN_FILES,
        K_MEM_USAGE,
        K_OPEN_FILES,
        K_RECEIVED_POINTS,
        K_REINDEX_PROGRESS,
        K_SELECTED_POINTS,
        K_SYNC_PROGRESS,
        K_UPTIME
    ), new Token(","), 1, null, false);
    private static final Element GROUP_COLUMNS = new List(Ids.GROUP_COLUMNS, new Choice(
        false,
        K_EXPRESSION,
        K_NAME,
        K_SERIES
    ), new Token(","), 1, null, false);
    private static final Element USER_COLUMNS = new List(Ids.USER_COLUMNS, new Choice(
        false,
        K_NAME,
        K_ACCESS
    ), new Token(","), 1, null, false);
    private static final Element POOL_PROPS = new Choice(
        Ids.POOL_PROPS,
        false,
        K_POOL,
        K_SERVERS,
        K_SERIES
    );
    private static final Element POOL_COLUMNS = new List(Ids.POOL_COLUMNS, POOL_PROPS, new Token(","), 1, null, false);
    private static final Element BOOL_OPERATOR = new Tokens(Ids.BOOL_OPERATOR, "== !=");
    private static final Element INT_OPERATOR = new Tokens(Ids.INT_OPERATOR, "== != <= >= < >");
    private static final Element STR_OPERATOR = new Tokens(Ids.STR_OPERATOR, "== != <= >= !~ < > ~");
    private static final Element WHERE_GROUP = new Sequence(
        Ids.WHERE_GROUP,
        K_WHERE,
        new Prio(
            new Sequence(
                K_SERIES,
                INT_OPERATOR,
                INT_EXPR
            ),
            new Sequence(
                new Choice(
                    false,
                    K_EXPRESSION,
                    K_NAME
                ),
                STR_OPERATOR,
                STRING
            ),
            new Sequence(
                new Token("("),
                This.THIS,
                new Token(")")
            ),
            new Sequence(
                This.THIS,
                K_AND,
                This.THIS
            ),
            new Sequence(
                This.THIS,
                K_OR,
                This.THIS
            )
        )
    );
    private static final Element WHERE_POOL = new Sequence(
        Ids.WHERE_POOL,
        K_WHERE,
        new Prio(
            new Sequence(
                POOL_PROPS,
                INT_OPERATOR,
                INT_EXPR
            ),
            new Sequence(
                new Token("("),
                This.THIS,
                new Token(")")
            ),
            new Sequence(
                This.THIS,
                K_AND,
                This.THIS
            ),
            new Sequence(
                This.THIS,
                K_OR,
                This.THIS
            )
        )
    );
    private static final Element WHERE_SERIES = new Sequence(
        Ids.WHERE_SERIES,
        K_WHERE,
        new Prio(
            new Sequence(
                new Choice(
                    false,
                    K_LENGTH,
                    K_POOL
                ),
                INT_OPERATOR,
                INT_EXPR
            ),
            new Sequence(
                K_NAME,
                STR_OPERATOR,
                STRING
            ),
            new Sequence(
                new Choice(
                    false,
                    K_START,
                    K_END
                ),
                INT_OPERATOR,
                TIME_EXPR
            ),
            new Sequence(
                K_TYPE,
                BOOL_OPERATOR,
                new Choice(
                    false,
                    K_STRING,
                    K_INTEGER,
                    K_FLOAT
                )
            ),
            new Sequence(
                new Token("("),
                This.THIS,
                new Token(")")
            ),
            new Sequence(
                This.THIS,
                K_AND,
                This.THIS
            ),
            new Sequence(
                This.THIS,
                K_OR,
                This.THIS
            )
        )
    );
    private static final Element WHERE_SERVER = new Sequence(
        Ids.WHERE_SERVER,
        K_WHERE,
        new Prio(
            new Sequence(
                new Choice(
                    false,
                    K_ACTIVE_HANDLES,
                    K_ACTIVE_TASKS,
                    K_BUFFER_SIZE,
                    K_FIFO_FILES,
                    K_IDLE_PERCENTAGE,
                    K_IDLE_TIME,
                    K_PORT,
                    K_POOL,
                    K_STARTUP_TIME,
                    K_MAX_OPEN_FILES,
                    K_MEM_USAGE,
                    K_OPEN_FILES,
                    K_RECEIVED_POINTS,
                    K_SELECTED_POINTS,
                    K_UPTIME
                ),
                INT_OPERATOR,
                INT_EXPR
            ),
            new Sequence(
                new Choice(
                    false,
                    K_ADDRESS,
                    K_BUFFER_PATH,
                    K_DBPATH,
                    K_IP_SUPPORT,
                    K_LIBUV,
                    K_NAME,
                    K_UUID,
                    K_VERSION,
                    K_STATUS,
                    K_REINDEX_PROGRESS,
                    K_SYNC_PROGRESS
                ),
                STR_OPERATOR,
                STRING
            ),
            new Sequence(
                K_ONLINE,
                BOOL_OPERATOR,
                _BOOLEAN
            ),
            new Sequence(
                K_LOG_LEVEL,
                INT_OPERATOR,
                LOG_KEYWORDS
            ),
            new Sequence(
                new Token("("),
                This.THIS,
                new Token(")")
            ),
            new Sequence(
                This.THIS,
                K_AND,
                This.THIS
            ),
            new Sequence(
                This.THIS,
                K_OR,
                This.THIS
            )
        )
    );
    private static final Element WHERE_SHARD = new Sequence(
        Ids.WHERE_SHARD,
        K_WHERE,
        new Prio(
            new Sequence(
                new Choice(
                    false,
                    K_SID,
                    K_POOL,
                    K_SIZE
                ),
                INT_OPERATOR,
                INT_EXPR
            ),
            new Sequence(
                new Choice(
                    true,
                    K_SERVER,
                    K_STATUS
                ),
                STR_OPERATOR,
                STRING
            ),
            new Sequence(
                new Choice(
                    false,
                    K_START,
                    K_END
                ),
                INT_OPERATOR,
                TIME_EXPR
            ),
            new Sequence(
                K_TYPE,
                BOOL_OPERATOR,
                new Choice(
                    false,
                    K_NUMBER,
                    K_LOG
                )
            ),
            new Sequence(
                new Token("("),
                This.THIS,
                new Token(")")
            ),
            new Sequence(
                This.THIS,
                K_AND,
                This.THIS
            ),
            new Sequence(
                This.THIS,
                K_OR,
                This.THIS
            )
        )
    );
    private static final Element WHERE_USER = new Sequence(
        Ids.WHERE_USER,
        K_WHERE,
        new Prio(
            new Sequence(
                K_NAME,
                STR_OPERATOR,
                STRING
            ),
            new Sequence(
                K_ACCESS,
                INT_OPERATOR,
                ACCESS_KEYWORDS
            ),
            new Sequence(
                new Token("("),
                This.THIS,
                new Token(")")
            ),
            new Sequence(
                This.THIS,
                K_AND,
                This.THIS
            ),
            new Sequence(
                This.THIS,
                K_OR,
                This.THIS
            )
        )
    );
    private static final Element SERIES_SEP = new Choice(
        Ids.SERIES_SEP,
        false,
        K_UNION,
        C_DIFFERENCE,
        K_INTERSECTION,
        K_SYMMETRIC_DIFFERENCE
    );
    private static final Element SERIES_ALL = new Choice(
        Ids.SERIES_ALL,
        false,
        new Token("*"),
        K_ALL
    );
    private static final Element SERIES_NAME = new Repeat(Ids.SERIES_NAME, STRING, 1, 1);
    private static final Element GROUP_NAME = new Repeat(Ids.GROUP_NAME, R_GRAVE_STR, 1, 1);
    private static final Element SERIES_RE = new Repeat(Ids.SERIES_RE, R_REGEX, 1, 1);
    private static final Element UUID = new Choice(
        Ids.UUID,
        false,
        R_UUID_STR,
        STRING
    );
    private static final Element GROUP_MATCH = new Repeat(Ids.GROUP_MATCH, R_GRAVE_STR, 1, 1);
    private static final Element SERIES_MATCH = new List(Ids.SERIES_MATCH, new Choice(
        false,
        SERIES_ALL,
        SERIES_NAME,
        GROUP_MATCH,
        SERIES_RE
    ), SERIES_SEP, 1, null, false);
    private static final Element LIMIT_EXPR = new Sequence(
        Ids.LIMIT_EXPR,
        K_LIMIT,
        INT_EXPR
    );
    private static final Element BEFORE_EXPR = new Sequence(
        Ids.BEFORE_EXPR,
        K_BEFORE,
        TIME_EXPR
    );
    private static final Element AFTER_EXPR = new Sequence(
        Ids.AFTER_EXPR,
        K_AFTER,
        TIME_EXPR
    );
    private static final Element BETWEEN_EXPR = new Sequence(
        Ids.BETWEEN_EXPR,
        K_BETWEEN,
        TIME_EXPR,
        K_AND,
        TIME_EXPR
    );
    private static final Element ACCESS_EXPR = new List(Ids.ACCESS_EXPR, ACCESS_KEYWORDS, new Token(","), 1, null, false);
    private static final Element PREFIX_EXPR = new Sequence(
        Ids.PREFIX_EXPR,
        K_PREFIX,
        STRING
    );
    private static final Element SUFFIX_EXPR = new Sequence(
        Ids.SUFFIX_EXPR,
        K_SUFFIX,
        STRING
    );
    private static final Element F_ALL = new Choice(
        Ids.F_ALL,
        false,
        new Token("*"),
        K_ALL
    );
    private static final Element F_POINTS = new Repeat(Ids.F_POINTS, K_POINTS, 1, 1);
    private static final Element F_DIFFERENCE = new Sequence(
        Ids.F_DIFFERENCE,
        K_DIFFERENCE,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_DERIVATIVE = new Sequence(
        Ids.F_DERIVATIVE,
        K_DERIVATIVE,
        new Token("("),
        new List(TIME_EXPR, new Token(","), 0, 2, false),
        new Token(")")
    );
    private static final Element F_MEAN = new Sequence(
        Ids.F_MEAN,
        K_MEAN,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_MEDIAN = new Sequence(
        Ids.F_MEDIAN,
        K_MEDIAN,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_MEDIAN_LOW = new Sequence(
        Ids.F_MEDIAN_LOW,
        K_MEDIAN_LOW,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_MEDIAN_HIGH = new Sequence(
        Ids.F_MEDIAN_HIGH,
        K_MEDIAN_HIGH,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_SUM = new Sequence(
        Ids.F_SUM,
        K_SUM,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_MIN = new Sequence(
        Ids.F_MIN,
        K_MIN,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_MAX = new Sequence(
        Ids.F_MAX,
        K_MAX,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_COUNT = new Sequence(
        Ids.F_COUNT,
        K_COUNT,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_VARIANCE = new Sequence(
        Ids.F_VARIANCE,
        K_VARIANCE,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_PVARIANCE = new Sequence(
        Ids.F_PVARIANCE,
        K_PVARIANCE,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_STDDEV = new Sequence(
        Ids.F_STDDEV,
        K_STDDEV,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_FIRST = new Sequence(
        Ids.F_FIRST,
        K_FIRST,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_LAST = new Sequence(
        Ids.F_LAST,
        K_LAST,
        new Token("("),
        new Optional(TIME_EXPR),
        new Token(")")
    );
    private static final Element F_FILTER = new Sequence(
        Ids.F_FILTER,
        K_FILTER,
        new Token("("),
        new Optional(STR_OPERATOR),
        new Choice(
            true,
            STRING,
            R_INTEGER,
            R_FLOAT,
            R_REGEX,
            K_NAN,
            K_INF,
            K_NINF
        ),
        new Token(")")
    );
    private static final Element F_LIMIT = new Sequence(
        Ids.F_LIMIT,
        K_LIMIT,
        new Token("("),
        INT_EXPR,
        new Token(","),
        new Choice(
            false,
            K_MEAN,
            K_MEDIAN,
            K_MEDIAN_HIGH,
            K_MEDIAN_LOW,
            K_SUM,
            K_MIN,
            K_MAX,
            K_COUNT,
            K_VARIANCE,
            K_PVARIANCE,
            K_STDDEV,
            K_FIRST,
            K_LAST
        ),
        new Token(")")
    );
    private static final Element AGGREGATE_FUNCTIONS = new List(Ids.AGGREGATE_FUNCTIONS, new Choice(
        false,
        F_ALL,
        F_LIMIT,
        F_MEAN,
        F_SUM,
        F_MEDIAN,
        F_MEDIAN_LOW,
        F_MEDIAN_HIGH,
        F_MIN,
        F_MAX,
        F_COUNT,
        F_VARIANCE,
        F_PVARIANCE,
        F_STDDEV,
        F_FIRST,
        F_LAST,
        F_DIFFERENCE,
        F_DERIVATIVE,
        F_FILTER,
        F_POINTS
    ), new Token("=>"), 1, null, false);
    private static final Element SELECT_AGGREGATE = new Sequence(
        Ids.SELECT_AGGREGATE,
        AGGREGATE_FUNCTIONS,
        new Optional(PREFIX_EXPR),
        new Optional(SUFFIX_EXPR)
    );
    private static final Element SELECT_AGGREGATES = new List(Ids.SELECT_AGGREGATES, SELECT_AGGREGATE, new Token(","), 1, null, false);
    private static final Element MERGE_AS = new Sequence(
        Ids.MERGE_AS,
        K_MERGE,
        K_AS,
        STRING,
        new Optional(new Sequence(
            K_USING,
            AGGREGATE_FUNCTIONS
        ))
    );
    private static final Element SET_ADDRESS = new Sequence(
        Ids.SET_ADDRESS,
        K_SET,
        K_ADDRESS,
        STRING
    );
    private static final Element SET_BACKUP_MODE = new Sequence(
        Ids.SET_BACKUP_MODE,
        K_SET,
        K_BACKUP_MODE,
        _BOOLEAN
    );
    private static final Element SET_DROP_THRESHOLD = new Sequence(
        Ids.SET_DROP_THRESHOLD,
        K_SET,
        K_DROP_THRESHOLD,
        R_FLOAT
    );
    private static final Element SET_EXPRESSION = new Sequence(
        Ids.SET_EXPRESSION,
        K_SET,
        K_EXPRESSION,
        R_REGEX
    );
    private static final Element SET_IGNORE_THRESHOLD = new Sequence(
        Ids.SET_IGNORE_THRESHOLD,
        K_SET,
        K_IGNORE_THRESHOLD,
        _BOOLEAN
    );
    private static final Element SET_LIST_LIMIT = new Sequence(
        Ids.SET_LIST_LIMIT,
        K_SET,
        K_LIST_LIMIT,
        R_UINTEGER
    );
    private static final Element SET_LOG_LEVEL = new Sequence(
        Ids.SET_LOG_LEVEL,
        K_SET,
        K_LOG_LEVEL,
        LOG_KEYWORDS
    );
    private static final Element SET_NAME = new Sequence(
        Ids.SET_NAME,
        K_SET,
        K_NAME,
        STRING
    );
    private static final Element SET_PASSWORD = new Sequence(
        Ids.SET_PASSWORD,
        K_SET,
        K_PASSWORD,
        STRING
    );
    private static final Element SET_PORT = new Sequence(
        Ids.SET_PORT,
        K_SET,
        K_PORT,
        R_UINTEGER
    );
    private static final Element SET_SELECT_POINTS_LIMIT = new Sequence(
        Ids.SET_SELECT_POINTS_LIMIT,
        K_SET,
        K_SELECT_POINTS_LIMIT,
        R_UINTEGER
    );
    private static final Element SET_TIMEZONE = new Sequence(
        Ids.SET_TIMEZONE,
        K_SET,
        K_TIMEZONE,
        STRING
    );
    private static final Element ALTER_DATABASE = new Sequence(
        Ids.ALTER_DATABASE,
        K_DATABASE,
        new Choice(
            false,
            SET_DROP_THRESHOLD,
            SET_LIST_LIMIT,
            SET_SELECT_POINTS_LIMIT,
            SET_TIMEZONE
        )
    );
    private static final Element ALTER_GROUP = new Sequence(
        Ids.ALTER_GROUP,
        K_GROUP,
        GROUP_NAME,
        new Choice(
            false,
            SET_EXPRESSION,
            SET_NAME
        )
    );
    private static final Element ALTER_SERVER = new Sequence(
        Ids.ALTER_SERVER,
        K_SERVER,
        UUID,
        new Choice(
            false,
            SET_LOG_LEVEL,
            SET_BACKUP_MODE,
            SET_ADDRESS,
            SET_PORT
        )
    );
    private static final Element ALTER_SERVERS = new Sequence(
        Ids.ALTER_SERVERS,
        K_SERVERS,
        new Optional(WHERE_SERVER),
        SET_LOG_LEVEL
    );
    private static final Element ALTER_USER = new Sequence(
        Ids.ALTER_USER,
        K_USER,
        STRING,
        new Choice(
            false,
            SET_PASSWORD,
            SET_NAME
        )
    );
    private static final Element COUNT_GROUPS = new Sequence(
        Ids.COUNT_GROUPS,
        K_GROUPS,
        new Optional(WHERE_GROUP)
    );
    private static final Element COUNT_POOLS = new Sequence(
        Ids.COUNT_POOLS,
        K_POOLS,
        new Optional(WHERE_POOL)
    );
    private static final Element COUNT_SERIES = new Sequence(
        Ids.COUNT_SERIES,
        K_SERIES,
        new Optional(SERIES_MATCH),
        new Optional(WHERE_SERIES)
    );
    private static final Element COUNT_SERVERS = new Sequence(
        Ids.COUNT_SERVERS,
        K_SERVERS,
        new Optional(WHERE_SERVER)
    );
    private static final Element COUNT_SERVERS_RECEIVED = new Sequence(
        Ids.COUNT_SERVERS_RECEIVED,
        K_SERVERS,
        K_RECEIVED_POINTS,
        new Optional(WHERE_SERVER)
    );
    private static final Element COUNT_SERVERS_SELECTED = new Sequence(
        Ids.COUNT_SERVERS_SELECTED,
        K_SERVERS,
        K_SELECTED_POINTS,
        new Optional(WHERE_SERVER)
    );
    private static final Element COUNT_SHARDS = new Sequence(
        Ids.COUNT_SHARDS,
        K_SHARDS,
        new Optional(WHERE_SHARD)
    );
    private static final Element COUNT_SHARDS_SIZE = new Sequence(
        Ids.COUNT_SHARDS_SIZE,
        K_SHARDS,
        K_SIZE,
        new Optional(WHERE_SHARD)
    );
    private static final Element COUNT_USERS = new Sequence(
        Ids.COUNT_USERS,
        K_USERS,
        new Optional(WHERE_USER)
    );
    private static final Element COUNT_SERIES_LENGTH = new Sequence(
        Ids.COUNT_SERIES_LENGTH,
        K_SERIES,
        K_LENGTH,
        new Optional(SERIES_MATCH),
        new Optional(WHERE_SERIES)
    );
    private static final Element CREATE_GROUP = new Sequence(
        Ids.CREATE_GROUP,
        K_GROUP,
        GROUP_NAME,
        K_FOR,
        R_REGEX
    );
    private static final Element CREATE_USER = new Sequence(
        Ids.CREATE_USER,
        K_USER,
        STRING,
        SET_PASSWORD
    );
    private static final Element DROP_GROUP = new Sequence(
        Ids.DROP_GROUP,
        K_GROUP,
        GROUP_NAME
    );
    private static final Element DROP_SERIES = new Sequence(
        Ids.DROP_SERIES,
        K_SERIES,
        new Optional(SERIES_MATCH),
        new Optional(WHERE_SERIES),
        new Optional(SET_IGNORE_THRESHOLD)
    );
    private static final Element DROP_SHARDS = new Sequence(
        Ids.DROP_SHARDS,
        K_SHARDS,
        new Optional(WHERE_SHARD),
        new Optional(SET_IGNORE_THRESHOLD)
    );
    private static final Element DROP_SERVER = new Sequence(
        Ids.DROP_SERVER,
        K_SERVER,
        UUID
    );
    private static final Element DROP_USER = new Sequence(
        Ids.DROP_USER,
        K_USER,
        STRING
    );
    private static final Element GRANT_USER = new Sequence(
        Ids.GRANT_USER,
        K_USER,
        STRING,
        new Optional(SET_PASSWORD)
    );
    private static final Element LIST_GROUPS = new Sequence(
        Ids.LIST_GROUPS,
        K_GROUPS,
        new Optional(GROUP_COLUMNS),
        new Optional(WHERE_GROUP)
    );
    private static final Element LIST_POOLS = new Sequence(
        Ids.LIST_POOLS,
        K_POOLS,
        new Optional(POOL_COLUMNS),
        new Optional(WHERE_POOL)
    );
    private static final Element LIST_SERIES = new Sequence(
        Ids.LIST_SERIES,
        K_SERIES,
        new Optional(SERIES_COLUMNS),
        new Optional(SERIES_MATCH),
        new Optional(WHERE_SERIES)
    );
    private static final Element LIST_SERVERS = new Sequence(
        Ids.LIST_SERVERS,
        K_SERVERS,
        new Optional(SERVER_COLUMNS),
        new Optional(WHERE_SERVER)
    );
    private static final Element LIST_SHARDS = new Sequence(
        Ids.LIST_SHARDS,
        K_SHARDS,
        new Optional(SHARD_COLUMNS),
        new Optional(WHERE_SHARD)
    );
    private static final Element LIST_USERS = new Sequence(
        Ids.LIST_USERS,
        K_USERS,
        new Optional(USER_COLUMNS),
        new Optional(WHERE_USER)
    );
    private static final Element REVOKE_USER = new Sequence(
        Ids.REVOKE_USER,
        K_USER,
        STRING
    );
    private static final Element ALTER_STMT = new Sequence(
        Ids.ALTER_STMT,
        K_ALTER,
        new Choice(
            false,
            ALTER_USER,
            ALTER_GROUP,
            ALTER_SERVER,
            ALTER_SERVERS,
            ALTER_DATABASE
        )
    );
    private static final Element CALC_STMT = new Repeat(Ids.CALC_STMT, TIME_EXPR, 1, 1);
    private static final Element COUNT_STMT = new Sequence(
        Ids.COUNT_STMT,
        K_COUNT,
        new Choice(
            true,
            COUNT_GROUPS,
            COUNT_POOLS,
            COUNT_SERIES,
            COUNT_SERVERS,
            COUNT_SERVERS_RECEIVED,
            COUNT_SERVERS_SELECTED,
            COUNT_SHARDS,
            COUNT_SHARDS_SIZE,
            COUNT_USERS,
            COUNT_SERIES_LENGTH
        )
    );
    private static final Element CREATE_STMT = new Sequence(
        Ids.CREATE_STMT,
        K_CREATE,
        new Choice(
            true,
            CREATE_GROUP,
            CREATE_USER
        )
    );
    private static final Element DROP_STMT = new Sequence(
        Ids.DROP_STMT,
        K_DROP,
        new Choice(
            false,
            DROP_GROUP,
            DROP_SERIES,
            DROP_SHARDS,
            DROP_SERVER,
            DROP_USER
        )
    );
    private static final Element GRANT_STMT = new Sequence(
        Ids.GRANT_STMT,
        K_GRANT,
        ACCESS_EXPR,
        K_TO,
        new Choice(
            false,
            GRANT_USER
        )
    );
    private static final Element LIST_STMT = new Sequence(
        Ids.LIST_STMT,
        K_LIST,
        new Choice(
            false,
            LIST_SERIES,
            LIST_USERS,
            LIST_SHARDS,
            LIST_GROUPS,
            LIST_SERVERS,
            LIST_POOLS
        ),
        new Optional(LIMIT_EXPR)
    );
    private static final Element REVOKE_STMT = new Sequence(
        Ids.REVOKE_STMT,
        K_REVOKE,
        ACCESS_EXPR,
        K_FROM,
        new Choice(
            false,
            REVOKE_USER
        )
    );
    private static final Element SELECT_STMT = new Sequence(
        Ids.SELECT_STMT,
        K_SELECT,
        SELECT_AGGREGATES,
        K_FROM,
        SERIES_MATCH,
        new Optional(WHERE_SERIES),
        new Optional(new Choice(
            false,
            AFTER_EXPR,
            BETWEEN_EXPR,
            BEFORE_EXPR
        )),
        new Optional(MERGE_AS)
    );
    private static final Element SHOW_STMT = new Sequence(
        Ids.SHOW_STMT,
        K_SHOW,
        new List(new Choice(
            false,
            K_ACTIVE_HANDLES,
            K_ACTIVE_TASKS,
            K_BUFFER_PATH,
            K_BUFFER_SIZE,
            K_DBNAME,
            K_DBPATH,
            K_DROP_THRESHOLD,
            K_DURATION_LOG,
            K_DURATION_NUM,
            K_FIFO_FILES,
            K_IDLE_PERCENTAGE,
            K_IDLE_TIME,
            K_IP_SUPPORT,
            K_LIBUV,
            K_LIST_LIMIT,
            K_LOG_LEVEL,
            K_MAX_OPEN_FILES,
            K_MEM_USAGE,
            K_OPEN_FILES,
            K_POOL,
            K_RECEIVED_POINTS,
            K_REINDEX_PROGRESS,
            K_SELECTED_POINTS,
            K_SELECT_POINTS_LIMIT,
            K_SERVER,
            K_STARTUP_TIME,
            K_STATUS,
            K_SYNC_PROGRESS,
            K_TIME_PRECISION,
            K_TIMEZONE,
            K_UPTIME,
            K_UUID,
            K_VERSION,
            K_WHO_AM_I
        ), new Token(","), 0, null, false)
    );
    private static final Element TIMEIT_STMT = new Repeat(Ids.TIMEIT_STMT, K_TIMEIT, 1, 1);
    private static final Element HELP_STMT = new Ref();
    private static final Element START = new Sequence(
        Ids.START,
        new Optional(TIMEIT_STMT),
        new Optional(new Choice(
            false,
            SELECT_STMT,
            LIST_STMT,
            COUNT_STMT,
            ALTER_STMT,
            CREATE_STMT,
            DROP_STMT,
            GRANT_STMT,
            REVOKE_STMT,
            SHOW_STMT,
            CALC_STMT,
            HELP_STMT
        )),
        new Optional(R_COMMENT)
    );
    private static final Element HELP_ACCESS = new Keyword(Ids.HELP_ACCESS, "access", false);
    private static final Element HELP_ALTER_DATABASE = new Keyword(Ids.HELP_ALTER_DATABASE, "database", false);
    private static final Element HELP_ALTER_GROUP = new Keyword(Ids.HELP_ALTER_GROUP, "group", false);
    private static final Element HELP_ALTER_SERVER = new Keyword(Ids.HELP_ALTER_SERVER, "server", false);
    private static final Element HELP_ALTER_SERVERS = new Keyword(Ids.HELP_ALTER_SERVERS, "servers", false);
    private static final Element HELP_ALTER_USER = new Keyword(Ids.HELP_ALTER_USER, "user", false);
    private static final Element HELP_ALTER = new Sequence(
        Ids.HELP_ALTER,
        K_ALTER,
        new Optional(new Choice(
            true,
            HELP_ALTER_DATABASE,
            HELP_ALTER_GROUP,
            HELP_ALTER_SERVER,
            HELP_ALTER_SERVERS,
            HELP_ALTER_USER
        ))
    );
    private static final Element HELP_COUNT_GROUPS = new Keyword(Ids.HELP_COUNT_GROUPS, "groups", false);
    private static final Element HELP_COUNT_POOLS = new Keyword(Ids.HELP_COUNT_POOLS, "pools", false);
    private static final Element HELP_COUNT_SERIES = new Keyword(Ids.HELP_COUNT_SERIES, "series", false);
    private static final Element HELP_COUNT_SERVERS = new Keyword(Ids.HELP_COUNT_SERVERS, "servers", false);
    private static final Element HELP_COUNT_SHARDS = new Keyword(Ids.HELP_COUNT_SHARDS, "shards", false);
    private static final Element HELP_COUNT_USERS = new Keyword(Ids.HELP_COUNT_USERS, "users", false);
    private static final Element HELP_COUNT = new Sequence(
        Ids.HELP_COUNT,
        K_COUNT,
        new Optional(new Choice(
            true,
            HELP_COUNT_GROUPS,
            HELP_COUNT_POOLS,
            HELP_COUNT_SERIES,
            HELP_COUNT_SERVERS,
            HELP_COUNT_SHARDS,
            HELP_COUNT_USERS
        ))
    );
    private static final Element HELP_CREATE_GROUP = new Keyword(Ids.HELP_CREATE_GROUP, "group", false);
    private static final Element HELP_CREATE_USER = new Keyword(Ids.HELP_CREATE_USER, "user", false);
    private static final Element HELP_CREATE = new Sequence(
        Ids.HELP_CREATE,
        K_CREATE,
        new Optional(new Choice(
            true,
            HELP_CREATE_GROUP,
            HELP_CREATE_USER
        ))
    );
    private static final Element HELP_DROP_GROUP = new Keyword(Ids.HELP_DROP_GROUP, "group", false);
    private static final Element HELP_DROP_SERIES = new Keyword(Ids.HELP_DROP_SERIES, "series", false);
    private static final Element HELP_DROP_SERVER = new Keyword(Ids.HELP_DROP_SERVER, "server", false);
    private static final Element HELP_DROP_SHARDS = new Keyword(Ids.HELP_DROP_SHARDS, "shards", false);
    private static final Element HELP_DROP_USER = new Keyword(Ids.HELP_DROP_USER, "user", false);
    private static final Element HELP_DROP = new Sequence(
        Ids.HELP_DROP,
        K_DROP,
        new Optional(new Choice(
            true,
            HELP_DROP_GROUP,
            HELP_DROP_SERIES,
            HELP_DROP_SERVER,
            HELP_DROP_SHARDS,
            HELP_DROP_USER
        ))
    );
    private static final Element HELP_FUNCTIONS = new Keyword(Ids.HELP_FUNCTIONS, "functions", false);
    private static final Element HELP_GRANT = new Keyword(Ids.HELP_GRANT, "grant", false);
    private static final Element HELP_LIST_GROUPS = new Keyword(Ids.HELP_LIST_GROUPS, "groups", false);
    private static final Element HELP_LIST_POOLS = new Keyword(Ids.HELP_LIST_POOLS, "pools", false);
    private static final Element HELP_LIST_SERIES = new Keyword(Ids.HELP_LIST_SERIES, "series", false);
    private static final Element HELP_LIST_SERVERS = new Keyword(Ids.HELP_LIST_SERVERS, "servers", false);
    private static final Element HELP_LIST_SHARDS = new Keyword(Ids.HELP_LIST_SHARDS, "shards", false);
    private static final Element HELP_LIST_USERS = new Keyword(Ids.HELP_LIST_USERS, "users", false);
    private static final Element HELP_LIST = new Sequence(
        Ids.HELP_LIST,
        K_LIST,
        new Optional(new Choice(
            true,
            HELP_LIST_GROUPS,
            HELP_LIST_POOLS,
            HELP_LIST_SERIES,
            HELP_LIST_SERVERS,
            HELP_LIST_SHARDS,
            HELP_LIST_USERS
        ))
    );
    private static final Element HELP_NOACCESS = new Keyword(Ids.HELP_NOACCESS, "noaccess", false);
    private static final Element HELP_REVOKE = new Keyword(Ids.HELP_REVOKE, "revoke", false);
    private static final Element HELP_SELECT = new Keyword(Ids.HELP_SELECT, "select", false);
    private static final Element HELP_SHOW = new Keyword(Ids.HELP_SHOW, "show", false);
    private static final Element HELP_TIMEIT = new Keyword(Ids.HELP_TIMEIT, "timeit", false);
    private static final Element HELP_TIMEZONES = new Keyword(Ids.HELP_TIMEZONES, "timezones", false);

    public SiriGrammar() {
        super(START, "^[a-z_]+");
        ((Ref) HELP_STMT).set(new Sequence(
            K_HELP,
            new Optional(new Choice(
                true,
                HELP_ACCESS,
                HELP_ALTER,
                HELP_COUNT,
                HELP_CREATE,
                HELP_DROP,
                HELP_FUNCTIONS,
                HELP_GRANT,
                HELP_LIST,
                HELP_NOACCESS,
                HELP_REVOKE,
                HELP_SELECT,
                HELP_SHOW,
                HELP_TIMEIT,
                HELP_TIMEZONES
            ))
        ));
    }
}
