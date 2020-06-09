package pl.kielce.tu.cassandra.mapper;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.data.GettableByName;
import com.datastax.oss.driver.api.core.data.SettableByName;
import com.datastax.oss.driver.api.core.metadata.schema.KeyspaceMetadata;
import com.datastax.oss.driver.api.core.metadata.schema.TableMetadata;
import com.datastax.oss.driver.api.core.type.DataType;
import com.datastax.oss.driver.api.core.type.UserDefinedType;
import com.datastax.oss.driver.api.core.type.reflect.GenericType;
import com.datastax.oss.driver.api.mapper.MapperContext;
import com.datastax.oss.driver.api.mapper.MapperException;
import com.datastax.oss.driver.api.mapper.entity.saving.NullSavingStrategy;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.delete.Delete;
import com.datastax.oss.driver.api.querybuilder.delete.DeleteSelection;
import com.datastax.oss.driver.api.querybuilder.insert.InsertInto;
import com.datastax.oss.driver.api.querybuilder.insert.RegularInsert;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.datastax.oss.driver.api.querybuilder.select.SelectFrom;
import com.datastax.oss.driver.api.querybuilder.update.UpdateStart;
import com.datastax.oss.driver.internal.mapper.entity.EntityHelperBase;
import com.datastax.oss.driver.internal.querybuilder.update.DefaultUpdate;
import com.datastax.oss.driver.shaded.guava.common.collect.ImmutableList;
import java.lang.Class;
import java.lang.Double;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generated by the DataStax driver mapper, do not edit directly.
 */
public class StudentHelper__MapperGenerated extends EntityHelperBase<Student> {
  private static final Logger LOG = LoggerFactory.getLogger(StudentHelper__MapperGenerated.class);

  private static final GenericType<List<String>> GENERIC_TYPE = new GenericType<List<String>>(){};

  private static final GenericType<Set<String>> GENERIC_TYPE1 = new GenericType<Set<String>>(){};

  private static final GenericType<Map<String, Double>> GENERIC_TYPE2 = new GenericType<Map<String, Double>>(){};

  private static final GenericType<Address> GENERIC_TYPE3 = new GenericType<Address>(){};

  private static final GenericType<Integer> GENERIC_TYPE4 = new GenericType<Integer>(){};

  private final List<String> primaryKeys;

  public StudentHelper__MapperGenerated(MapperContext context) {
    super(context, "student");
    LOG.debug("[{}] Entity Student will be mapped to {}{}",
        context.getSession().getName(),
        getKeyspaceId() == null ? "" : getKeyspaceId() + ".",
        getTableId());
    this.primaryKeys = ImmutableList.<String>builder()
        .add("id")
        .build();
  }

  @Override
  public Class<Student> getEntityClass() {
    return Student.class;
  }

  @Override
  public <SettableT extends SettableByName<SettableT>> SettableT set(Student entity,
      SettableT target, NullSavingStrategy nullSavingStrategy) {

    if (entity.getId() != null || nullSavingStrategy == NullSavingStrategy.SET_TO_NULL) {
      target = target.set("id", entity.getId(), Integer.class);
    }

    if (entity.getAge() != null || nullSavingStrategy == NullSavingStrategy.SET_TO_NULL) {
      target = target.set("age", entity.getAge(), Integer.class);
    }

    if (entity.getNames() != null || nullSavingStrategy == NullSavingStrategy.SET_TO_NULL) {
      target = target.set("names", entity.getNames(), GENERIC_TYPE);
    }

    if (entity.getAddress() != null || nullSavingStrategy == NullSavingStrategy.SET_TO_NULL) {
      target = target.set("address", entity.getAddress(), Address.class);
    }

    if (entity.getAwards() != null || nullSavingStrategy == NullSavingStrategy.SET_TO_NULL) {
      target = target.set("awards", entity.getAwards(), GENERIC_TYPE1);
    }

    if (entity.getMarks() != null || nullSavingStrategy == NullSavingStrategy.SET_TO_NULL) {
      target = target.set("marks", entity.getMarks(), GENERIC_TYPE2);
    }

    return target;
  }

  @Override
  public Student get(GettableByName source) {
    Student returnValue = new Student();

    returnValue.setId(source.get("id", Integer.class));

    returnValue.setAge(source.get("age", Integer.class));

    returnValue.setNames(source.get("names", GENERIC_TYPE));

    returnValue.setAddress(source.get("address", Address.class));

    returnValue.setAwards(source.get("awards", GENERIC_TYPE1));

    returnValue.setMarks(source.get("marks", GENERIC_TYPE2));
    return returnValue;
  }

  @Override
  public RegularInsert insert() {
    throwIfKeyspaceMissing();
    InsertInto insertInto = (keyspaceId == null)
        ? QueryBuilder.insertInto(tableId)
        : QueryBuilder.insertInto(keyspaceId, tableId);
    return insertInto
        .value("id", QueryBuilder.bindMarker("id"))
        .value("age", QueryBuilder.bindMarker("age"))
        .value("names", QueryBuilder.bindMarker("names"))
        .value("address", QueryBuilder.bindMarker("address"))
        .value("awards", QueryBuilder.bindMarker("awards"))
        .value("marks", QueryBuilder.bindMarker("marks"));
  }

  public Select selectByPrimaryKeyParts(int parameterCount) {
    Select select = selectStart();
    for (int i = 0; i < parameterCount && i < primaryKeys.size(); i++) {
      String columnName = primaryKeys.get(i);
      select = select.whereColumn(columnName).isEqualTo(QueryBuilder.bindMarker(columnName));
    }
    return select;
  }

  @Override
  public Select selectByPrimaryKey() {
    return selectByPrimaryKeyParts(primaryKeys.size());
  }

  @Override
  public Select selectStart() {
    throwIfKeyspaceMissing();
    SelectFrom selectFrom = (keyspaceId == null)
        ? QueryBuilder.selectFrom(tableId)
        : QueryBuilder.selectFrom(keyspaceId, tableId);
    return selectFrom
        .column("id")
        .column("age")
        .column("names")
        .column("address")
        .column("awards")
        .column("marks");
  }

  public DeleteSelection deleteStart() {
    throwIfKeyspaceMissing();
    return (keyspaceId == null)
        ? QueryBuilder.deleteFrom(tableId)
        : QueryBuilder.deleteFrom(keyspaceId, tableId);
  }

  public Delete deleteByPrimaryKeyParts(int parameterCount) {
    if (parameterCount <= 0) {
      throw new MapperException("parameterCount must be greater than 0");
    }
    DeleteSelection deleteSelection = deleteStart();
    String columnName = primaryKeys.get(0);
    Delete delete = deleteSelection.whereColumn(columnName).isEqualTo(QueryBuilder.bindMarker(columnName));
    for (int i = 1; i < parameterCount && i < primaryKeys.size(); i++) {
      columnName = primaryKeys.get(i);
      delete = delete.whereColumn(columnName).isEqualTo(QueryBuilder.bindMarker(columnName));
    }
    return delete;
  }

  @Override
  public Delete deleteByPrimaryKey() {
    return deleteByPrimaryKeyParts(primaryKeys.size());
  }

  @Override
  public DefaultUpdate updateStart() {
    throwIfKeyspaceMissing();
    UpdateStart update = (keyspaceId == null)
        ? QueryBuilder.update(tableId)
        : QueryBuilder.update(keyspaceId, tableId);
    return ((DefaultUpdate)update
        .setColumn("age", QueryBuilder.bindMarker("age"))
        .setColumn("names", QueryBuilder.bindMarker("names"))
        .setColumn("address", QueryBuilder.bindMarker("address"))
        .setColumn("awards", QueryBuilder.bindMarker("awards"))
        .setColumn("marks", QueryBuilder.bindMarker("marks")));
  }

  @Override
  public DefaultUpdate updateByPrimaryKey() {
    return ((DefaultUpdate)updateStart()
        .where(Relation.column("id").isEqualTo(QueryBuilder.bindMarker("id"))));
  }

  @Override
  public void validateEntityFields() {
    CqlIdentifier keyspaceId = this.keyspaceId != null ? this.keyspaceId : context.getSession().getKeyspace().orElse(null);
    String entityClassName = "pl.kielce.tu.cassandra.mapper.Student";
    if (keyspaceId == null) {
      LOG.warn("[{}] Unable to validate table: {} for the entity class: {} because the keyspace is unknown (the entity does not declare a default keyspace, and neither the session nor the DAO were created with a keyspace). The DAO will only work if it uses fully-qualified queries with @Query or @QueryProvider.",
          context.getSession().getName(),
          tableId,
          entityClassName);
      return;
    }
    if(!keyspaceNamePresent(context.getSession().getMetadata().getKeyspaces(), keyspaceId)) {
      LOG.warn("[{}] Unable to validate table: {} for the entity class: {} because the session metadata has no information about the keyspace: {}.",
          context.getSession().getName(),
          tableId,
          entityClassName,
          keyspaceId);
      return;
    }
    Optional<KeyspaceMetadata> keyspace = context.getSession().getMetadata().getKeyspace(keyspaceId);
    List<CqlIdentifier> expectedCqlNames = new ArrayList<>();
    expectedCqlNames.add(CqlIdentifier.fromCql("id"));
    expectedCqlNames.add(CqlIdentifier.fromCql("age"));
    expectedCqlNames.add(CqlIdentifier.fromCql("names"));
    expectedCqlNames.add(CqlIdentifier.fromCql("address"));
    expectedCqlNames.add(CqlIdentifier.fromCql("awards"));
    expectedCqlNames.add(CqlIdentifier.fromCql("marks"));
    Optional<TableMetadata> tableMetadata = keyspace.flatMap(v -> v.getTable(tableId));
    Optional<UserDefinedType> userDefinedType = keyspace.flatMap(v -> v.getUserDefinedType(tableId));
    if (tableMetadata.isPresent()) {
      // validation of missing PKs
      List<CqlIdentifier> expectedCqlPKs = new ArrayList<>();
      expectedCqlPKs.add(CqlIdentifier.fromCql("id"));
      List<CqlIdentifier> missingTablePksNames = findMissingColumns(expectedCqlPKs, tableMetadata.get().getPartitionKey());
      if (!missingTablePksNames.isEmpty()) {
        throw new IllegalArgumentException(String.format("The CQL ks.table: %s.%s has missing Primary Key columns: %s that are defined in the entity class: %s", keyspaceId, tableId, missingTablePksNames, entityClassName));
      }
      // validation of all columns
      List<CqlIdentifier> missingTableCqlNames = findMissingCqlIdentifiers(expectedCqlNames, tableMetadata.get().getColumns().keySet());
      if (!missingTableCqlNames.isEmpty()) {
        throw new IllegalArgumentException(String.format("The CQL ks.table: %s.%s has missing columns: %s that are defined in the entity class: %s", keyspaceId, tableId, missingTableCqlNames, entityClassName));
      }
      // validation of types
      Map<CqlIdentifier, GenericType<?>> expectedTypesPerColumn = new LinkedHashMap<>();
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("address"), GENERIC_TYPE3);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("id"), GENERIC_TYPE4);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("age"), GENERIC_TYPE4);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("awards"), GENERIC_TYPE1);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("marks"), GENERIC_TYPE2);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("names"), GENERIC_TYPE);
      List<String> missingTableTypes = findTypeMismatches(expectedTypesPerColumn, tableMetadata.get().getColumns(), context.getSession().getContext().getCodecRegistry());
      throwMissingTableTypesIfNotEmpty(missingTableTypes, keyspaceId, tableId, entityClassName);
    }
    else if (userDefinedType.isPresent()) {
      // validation of UDT columns
      List<CqlIdentifier> columns = userDefinedType.get().getFieldNames();
      List<CqlIdentifier> missingTableCqlNames = findMissingCqlIdentifiers(expectedCqlNames, columns);
      if (!missingTableCqlNames.isEmpty()) {
        throw new IllegalArgumentException(String.format("The CQL ks.udt: %s.%s has missing columns: %s that are defined in the entity class: %s", keyspaceId, tableId, missingTableCqlNames, entityClassName));
      }
      // validation of UDT types
      Map<CqlIdentifier, GenericType<?>> expectedTypesPerColumn = new LinkedHashMap<>();
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("address"), GENERIC_TYPE3);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("id"), GENERIC_TYPE4);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("age"), GENERIC_TYPE4);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("awards"), GENERIC_TYPE1);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("marks"), GENERIC_TYPE2);
      expectedTypesPerColumn.put(CqlIdentifier.fromCql("names"), GENERIC_TYPE);
      List<CqlIdentifier> expectedColumns = userDefinedType.get().getFieldNames();
      List<DataType> expectedTypes = userDefinedType.get().getFieldTypes();
      List<String> missingTableTypes = findTypeMismatches(expectedTypesPerColumn, expectedColumns, expectedTypes, context.getSession().getContext().getCodecRegistry());
      throwMissingUdtTypesIfNotEmpty(missingTableTypes, keyspaceId, tableId, entityClassName);
    }
    // warn if there is not keyspace.table for defined entity - it means that table is missing, or schema it out of date.
    else {
      LOG.warn("[{}] There is no ks.table or UDT: {}.{} for the entity class: {}, or metadata is out of date.",
          context.getSession().getName(),
          keyspaceId,
          tableId,
          entityClassName);
    }
  }
}
